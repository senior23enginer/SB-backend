package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain;

import java.util.List;

public interface DdDetalleBultosQueryRepository  {

    List<DdDetalleBultos> find();

    List<DdDetalleBultos> find(int limit, int offset);

    DdDetalleBultos findById(DdDetalleBultosKey key);

}
