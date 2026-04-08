package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;
public final class DdTemporalOrdenPickingMapper  {
    private DdTemporalOrdenPickingMapper() {

    }
    public static DdTemporalOrdenPicking from(CreateDdTemporalOrdenPickingCommand command) {
        return new DdTemporalOrdenPicking(command.getCodigoEmpresa(), command.getLoCodigo(), command.getSku(), command.getOrden(), command.getSep1(), command.getSep2(), command.getSep3());

    }

}
