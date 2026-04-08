package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain;

import java.util.List;

public interface DdOrdenPickingQueryRepository  {

    List<DdOrdenPicking> find();

    List<DdOrdenPicking> find(int limit, int offset);

    DdOrdenPicking findById(DdOrdenPickingKey key);

}
