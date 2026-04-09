package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.application.create.DdBultosCreateWithoutExistsCommand;
import com.mayoristas.interfaz_contable.picking.dd_bultos.application.create.DdBultosCreatorWithoutExists;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosAlreadyExistsException;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosPersistenceException;
import com.mayoristas.interfaz_contable.shared.infrastructure.controller.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/dd-bultos")
public class CreateDdBultosController {
    private final Logger log = LoggerFactory.getLogger(CreateDdBultosController.class);
    private final DdBultosCreatorWithoutExists useCase;

    public CreateDdBultosController(DdBultosCreatorWithoutExists useCase) {
        this.useCase = Objects.requireNonNull(useCase, "DdBultosCreatorWithoutExists no puede ser null");
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateDdBultosResponse>> create(@RequestBody CreateDdBultosRequest body) {
        try {
            DdBultos result = useCase.execute(new DdBultosCreateWithoutExistsCommand(
                    body.getCodigoEtiqueta(),
                    body.getIdRecvta(),
                    body.getImpresora(),
                    body.getFechaImpresion(),
                    body.getUsuarioImpresion(),
                    body.getIndUtilizado()
            ));

            return ResponseEntity.ok(ApiResponse.success(
                    "DdBultos creado correctamente",
                    new CreateDdBultosResponse(
                            result.getCodigoEtiqueta(),
                            result.getIdRecvta(),
                            result.getImpresora(),
                            result.getFechaImpresion(),
                            result.getUsuarioImpresion(),
                            result.getIndUtilizado()
                    )
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(extractBestMessage(e), "validation_error"));
        } catch (DdBultosAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(extractBestMessage(e), "already_exists"));
        } catch (DdBultosPersistenceException e) {
            log.error("Error createDdBultos", e);
            if (isMissingParentIdRecvta(e)) {
                return ResponseEntity.badRequest().body(
                        ApiResponse.error(
                                "El idRecvta no existe en SALCOBRAND.dd_pedido_picking.",
                                "foreign_key_violation"
                        )
                );
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error creando DdBultos", "data_access_error"));
        } catch (Exception e) {
            log.error("Error createDdBultos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno al crear DdBultos", "internal_error"));
        }
    }

    private String extractBestMessage(Throwable e) {
        if (e == null) {
            return "Error de validacion";
        }
        if (e.getMessage() != null && !e.getMessage().isBlank()) {
            return e.getMessage();
        }
        Throwable cause = e.getCause();
        if (cause != null && cause.getMessage() != null && !cause.getMessage().isBlank()) {
            return cause.getMessage();
        }
        return "Error de validacion";
    }

    private boolean isMissingParentIdRecvta(Throwable error) {
        Throwable current = error;
        while (current != null) {
            String message = current.getMessage();
            if (message != null) {
                String normalized = message.toUpperCase();
                if (normalized.contains("ORA-02291") || normalized.contains("DD_BULTOS_PED_PICK_FK")) {
                    return true;
                }
            }
            current = current.getCause();
        }
        return false;
    }
}
