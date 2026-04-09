package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.application.find.DdBultosFinderAll;
import com.mayoristas.interfaz_contable.picking.dd_bultos.application.find.DdBultosFinderById;
import com.mayoristas.interfaz_contable.picking.dd_bultos.application.find.FindAllDdBultosQuery;
import com.mayoristas.interfaz_contable.picking.dd_bultos.application.find.FindByIdDdBultosQuery;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosNotFoundException;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosPersistenceException;
import com.mayoristas.interfaz_contable.shared.infrastructure.controller.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/dd-bultos")
public class FindDdBultosController {
    private final Logger log = LoggerFactory.getLogger(FindDdBultosController.class);
    private final DdBultosFinderAll finderAll;
    private final DdBultosFinderById finderById;

    public FindDdBultosController(DdBultosFinderAll finderAll, DdBultosFinderById finderById) {
        this.finderAll = Objects.requireNonNull(finderAll, "DdBultosFinderAll no puede ser null");
        this.finderById = Objects.requireNonNull(finderById, "DdBultosFinderById no puede ser null");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PagedFindDdBultosResponse>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit
    ) {
        try {
            List<FindDdBultosItemResponse> content = finderAll.execute(new FindAllDdBultosQuery(page, limit))
                    .stream()
                    .map(this::toItem)
                    .toList();

            PagedFindDdBultosResponse response = new PagedFindDdBultosResponse(content, page, limit, content.size());
            return ResponseEntity.ok(ApiResponse.success("DdBultos listados correctamente", response));
        } catch (DdBultosPersistenceException e) {
            log.error("Error findAllDdBultos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error consultando DdBultos", "data_access_error"));
        } catch (Exception e) {
            log.error("Error findAllDdBultos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno al consultar DdBultos", "internal_error"));
        }
    }

    @GetMapping(params = "codigoEtiqueta")
    public ResponseEntity<ApiResponse<FindDdBultosItemResponse>> findById(@RequestParam("codigoEtiqueta") Long codigoEtiqueta) {
        try {
            DdBultos result = finderById.execute(new FindByIdDdBultosQuery(codigoEtiqueta));
            return ResponseEntity.ok(ApiResponse.success("DdBultos encontrado correctamente", toItem(result)));
        } catch (DdBultosNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(extractBestMessage(e), "not_found"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(extractBestMessage(e), "validation_error"));
        } catch (DdBultosPersistenceException e) {
            log.error("Error findDdBultosById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error consultando DdBultos", "data_access_error"));
        } catch (Exception e) {
            log.error("Error findDdBultosById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno al consultar DdBultos", "internal_error"));
        }
    }

    private FindDdBultosItemResponse toItem(DdBultos item) {
        return new FindDdBultosItemResponse(
                item.getCodigoEtiqueta(),
                item.getIdRecvta(),
                item.getImpresora(),
                item.getFechaImpresion(),
                item.getUsuarioImpresion(),
                item.getIndUtilizado()
        );
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
}
