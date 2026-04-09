package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.create;

import java.time.LocalDateTime;

public record CreateDdBultosResponse(
        Long codigoEtiqueta,
        Long idRecvta,
        String impresora,
        LocalDateTime fechaImpresion,
        String usuarioImpresion,
        String indUtilizado
) {
}
