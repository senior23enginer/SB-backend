package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;
public final class DdOrdenPickingMapper  {
    private DdOrdenPickingMapper() {

    }
    public static DdOrdenPicking from(CreateDdOrdenPickingCommand command) {
        return new DdOrdenPicking(command.getCodigoEmpresa(), command.getLoCodigo(), command.getSku(), command.getOrden(), command.getSep1(), command.getSep2(), command.getSep3());

    }

}
