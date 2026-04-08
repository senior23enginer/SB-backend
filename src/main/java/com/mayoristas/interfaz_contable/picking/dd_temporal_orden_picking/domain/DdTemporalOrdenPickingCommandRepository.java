package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain;

public interface DdTemporalOrdenPickingCommandRepository  {

    int create(DdTemporalOrdenPicking entity);

    int update(DdTemporalOrdenPicking entity);

    int delete(DdTemporalOrdenPickingKey key);

}
