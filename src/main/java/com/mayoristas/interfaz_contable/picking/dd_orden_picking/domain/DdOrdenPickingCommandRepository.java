package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain;

public interface DdOrdenPickingCommandRepository  {

    int create(DdOrdenPicking entity);

    int update(DdOrdenPicking entity);

    int delete(DdOrdenPickingKey key);

}
