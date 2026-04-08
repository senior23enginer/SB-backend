package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain;

public interface DdDetalleBultosCommandRepository  {

    int create(DdDetalleBultos entity);

    int update(DdDetalleBultos entity);

    int delete(DdDetalleBultosKey key);

}
