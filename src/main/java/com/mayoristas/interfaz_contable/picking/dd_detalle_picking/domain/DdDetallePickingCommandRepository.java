package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain;

public interface DdDetallePickingCommandRepository  {

    int create(DdDetallePicking entity);

    int update(DdDetallePicking entity);

    int delete(DdDetallePickingKey key);

}
