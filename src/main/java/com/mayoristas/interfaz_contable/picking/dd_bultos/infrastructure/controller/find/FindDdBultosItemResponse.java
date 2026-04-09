package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.find;

import java.time.LocalDateTime;

public record FindDdBultosItemResponse(
        Long codigoEtiqueta,
        Long idRecvta,
        String impresora,
        LocalDateTime fechaImpresion,
        String usuarioImpresion,
        String indUtilizado
) {
}
