package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create.CreateDdOrdenPickingCommand;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking}
 * validando previamente que no exista por llave primaria.
 */
public class DdOrdenPickingCreateWithoutExistsCommand extends CreateDdOrdenPickingCommand {

    public DdOrdenPickingCreateWithoutExistsCommand(Long codigoEmpresa, Long loCodigo, String sku, Long orden, String sep1, String sep2, String sep3) {
        super(codigoEmpresa, loCodigo, sku, orden, sep1, sep2, sep3);
    }
}
