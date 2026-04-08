package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;
public final class DdDetalleBultosMapper  {
    private DdDetalleBultosMapper() {

    }
    public static DdDetalleBultos from(CreateDdDetalleBultosCommand command) {
        return new DdDetalleBultos(command.getCodigoEtiqueta(), command.getInventoryItemId(), command.getCantidad());

    }

}
