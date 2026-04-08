package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain;

import java.util.List;

public interface DdDetallePickingQueryRepository  {

    List<DdDetallePicking> find();

    List<DdDetallePicking> find(int limit, int offset);

    DdDetallePicking findById(DdDetallePickingKey key);

}
