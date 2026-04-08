package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create.CreateDdOrdenPickingCommand;

public class UpdateDdOrdenPickingCommand extends CreateDdOrdenPickingCommand  {
    public UpdateDdOrdenPickingCommand(Long codigoEmpresa, Long loCodigo, String sku, Long orden, String sep1, String sep2, String sep3) {
        super(codigoEmpresa, loCodigo, sku, orden, sep1, sep2, sep3);

    }

}
