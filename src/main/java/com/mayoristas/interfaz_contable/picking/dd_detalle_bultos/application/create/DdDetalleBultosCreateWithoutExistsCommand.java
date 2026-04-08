package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create.CreateDdDetalleBultosCommand;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos}
 * validando previamente que no exista por llave primaria.
 */
public class DdDetalleBultosCreateWithoutExistsCommand extends CreateDdDetalleBultosCommand {

    public DdDetalleBultosCreateWithoutExistsCommand(Long codigoEtiqueta, Long inventoryItemId, Long cantidad) {
        super(codigoEtiqueta, inventoryItemId, cantidad);
    }
}
