package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.update.UpdateDdTemporalOrdenPickingCommand;

public class UpdateDdTemporalOrdenPickingByIdCommand extends UpdateDdTemporalOrdenPickingCommand  {
    public UpdateDdTemporalOrdenPickingByIdCommand(Long codigoEmpresa, Long loCodigo, String sku, Long orden, String sep1, String sep2, String sep3) {
        super(codigoEmpresa, loCodigo, sku, orden, sep1, sep2, sep3);

    }

}
