package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.controller.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find.ConsultarEstadoUsuarioHandler;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find.ConsultarEstadoUsuarioQuery;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuario;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.EstadoUsuarioPersistenceException;
import com.mayoristas.interfaz_contable.shared.infrastructure.controller.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/dd-pedido-picking")
@Tag(name = "Pedido Picking", description = "Operaciones relacionadas con el estado del picking de pedidos")
public class ConsultarEstadoUsuarioController {

    private final Logger log = LoggerFactory.getLogger(ConsultarEstadoUsuarioController.class);
    private final ConsultarEstadoUsuarioHandler handler;

    public ConsultarEstadoUsuarioController(ConsultarEstadoUsuarioHandler handler) {
        this.handler = Objects.requireNonNull(handler, "ConsultarEstadoUsuarioHandler no puede ser null");
    }

    @GetMapping("/estado-usuario")
    @Operation(
            summary = "Consultar estado del usuario",
            description = "Sincroniza el estado del usuario y verifica si existe un pedido con estado 'En Picking'. " +
                    "Esta operación se ejecuta automáticamente antes de mostrar el menú para verificar si el operario " +
                    "dejó un pedido a medias en una sesión anterior."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Estado del usuario consultado exitosamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Parámetros de entrada inválidos"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "No existe estado registrado para este usuario en este local"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    public ResponseEntity<ApiResponse<?>> consultarEstadoUsuario(
            @Parameter(
                    name = "usuarioId",
                    description = "Identificador único del usuario/operario",
                    example = "USER1",
                    required = true
            )
            @RequestParam("usuarioId") String usuarioId,

            @Parameter(
                    name = "localCode",
                    description = "Código del local/despachador",
                    example = "101",
                    required = true
            )
            @RequestParam("localCode") Long localCode
    ) {
        try {
            // Validar parámetros
            if (usuarioId == null || usuarioId.trim().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("usuarioId es requerido y no puede estar vacío", "validation_error"));
            }

            if (localCode == null || localCode <= 0) {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("localCode es requerido y debe ser mayor que cero", "validation_error"));
            }

            // Ejecutar query
            ConsultarEstadoUsuarioQuery query = new ConsultarEstadoUsuarioQuery(usuarioId, localCode);
            Optional<EstadoUsuario> estadoUsuario = handler.execute(query);

            if (estadoUsuario.isEmpty()) {
                log.info("No existe estado registrado para usuario: {} en local: {}", usuarioId, localCode);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(
                                "No existe estado registrado para este usuario en este local",
                                "not_found"
                        ));
            }

            EstadoUsuario estado = estadoUsuario.get();
            ConsultarEstadoUsuarioResponse response = toResponse(estado);

            String mensaje = estado.tienePickingEnCurso()
                    ? "Usuario tiene picking en curso"
                    : "Estado del usuario consultado exitosamente";

            return ResponseEntity.ok(ApiResponse.success(mensaje, response));

        } catch (IllegalArgumentException e) {
            log.warn("Error de validación en consultarEstadoUsuario: {}", e.getMessage());
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error(extractBestMessage(e), "validation_error"));
        } catch (EstadoUsuarioPersistenceException e) {
            log.error("Error de persistencia en consultarEstadoUsuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error consultando estado del usuario", "data_access_error"));
        } catch (Exception e) {
            log.error("Error inesperado en consultarEstadoUsuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno al consultar el estado del usuario", "internal_error"));
        }
    }

    private ConsultarEstadoUsuarioResponse toResponse(EstadoUsuario estadoUsuario) {
        return new ConsultarEstadoUsuarioResponse(
                estadoUsuario.getIdRecvta(),
                estadoUsuario.getEstadoPedido().getValue(),
                estadoUsuario.getFechaEstado(),
                estadoUsuario.getUsuarioId().getValue(),
                estadoUsuario.getLocalCode().getValue(),
                estadoUsuario.tienePickingEnCurso()
        );
    }

    private String extractBestMessage(Throwable e) {
        if (e == null) {
            return "Error de validación";
        }
        if (e.getMessage() != null && !e.getMessage().isBlank()) {
            return e.getMessage();
        }
        Throwable cause = e.getCause();
        if (cause != null && cause.getMessage() != null && !cause.getMessage().isBlank()) {
            return cause.getMessage();
        }
        return "Error de validación";
    }
}

