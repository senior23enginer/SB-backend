package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain;

import java.util.List;

public interface DdTemporalOrdenPickingQueryRepository  {

    List<DdTemporalOrdenPicking> find();

    List<DdTemporalOrdenPicking> find(int limit, int offset);

    DdTemporalOrdenPicking findById(DdTemporalOrdenPickingKey key);

}
