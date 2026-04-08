package com.mayoristas.interfaz_contable.picking.dd_bultos.domain;

import java.util.List;

public interface DdBultosQueryRepository  {

    List<DdBultos> find();

    List<DdBultos> find(int limit, int offset);

    DdBultos findById(DdBultosKey key);

}
