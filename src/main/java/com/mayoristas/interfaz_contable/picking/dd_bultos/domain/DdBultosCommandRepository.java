package com.mayoristas.interfaz_contable.picking.dd_bultos.domain;

public interface DdBultosCommandRepository  {

    int create(DdBultos entity);

    int update(DdBultos entity);

    int delete(DdBultosKey key);

}
