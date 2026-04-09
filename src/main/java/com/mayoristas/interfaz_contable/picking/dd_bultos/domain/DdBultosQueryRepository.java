package com.mayoristas.interfaz_contable.picking.dd_bultos.domain;

import java.util.List;

public interface DdBultosQueryRepository  {

    List<DdBultos> find();

    List<DdBultos> find(int limit, int offset);

    DdBultos findById(DdBultosKey key);

    List<DdBultos> findByFilters(
            Long idRecvta,
            String impresora,
            String usuarioImpresion,
            String indUtilizado,
            int limit,
            int offset
    );

}
