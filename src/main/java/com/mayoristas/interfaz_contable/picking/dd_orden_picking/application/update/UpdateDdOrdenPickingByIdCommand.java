package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.update.UpdateDdOrdenPickingCommand;

public class UpdateDdOrdenPickingByIdCommand extends UpdateDdOrdenPickingCommand  {
    public UpdateDdOrdenPickingByIdCommand(Long codigoEmpresa, Long loCodigo, String sku, Long orden, String sep1, String sep2, String sep3) {
        super(codigoEmpresa, loCodigo, sku, orden, sep1, sep2, sep3);

    }

}
