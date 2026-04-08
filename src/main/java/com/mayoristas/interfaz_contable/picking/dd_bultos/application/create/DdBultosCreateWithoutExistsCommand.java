package com.mayoristas.interfaz_contable.picking.dd_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create.CreateDdBultosCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos}
 * validando previamente que no exista por llave primaria.
 */
public class DdBultosCreateWithoutExistsCommand extends CreateDdBultosCommand {

    public DdBultosCreateWithoutExistsCommand(Long codigoEtiqueta, Long idRecvta, String impresora, LocalDateTime fechaImpresion, String usuarioImpresion, String indUtilizado) {
        super(codigoEtiqueta, idRecvta, impresora, fechaImpresion, usuarioImpresion, indUtilizado);
    }
}
