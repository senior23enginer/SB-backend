package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
public final class DdDetallePickingMapper  {
    private DdDetallePickingMapper() {

    }
    public static DdDetallePicking from(CreateDdDetallePickingCommand command) {
        return new DdDetallePicking(command.getIdRecvta(), command.getInventoryItemId(), command.getCantidad(), command.getFechaRegistro(), command.getUsuarioRegistro(), command.getCodigoEtiqueta());

    }

}
