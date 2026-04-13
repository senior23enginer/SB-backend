package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.controller.find;

import java.time.LocalDateTime;

public record ConsultarEstadoUsuarioResponse(
        Long idRecvta,
        String estado,
        LocalDateTime fechaEstado,
        String usuarioEstado,
        Long localCode,
        boolean tienePickingEnCurso
) {
}

