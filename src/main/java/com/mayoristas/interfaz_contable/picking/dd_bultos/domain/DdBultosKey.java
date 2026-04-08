package com.mayoristas.interfaz_contable.picking.dd_bultos.domain;

import java.time.LocalDateTime;

public class DdBultosKey  {

    private final Long codigoEtiqueta;

    public DdBultosKey(
    Long codigoEtiqueta
    )  {

        this.codigoEtiqueta = codigoEtiqueta;

    }

    public Long getCodigoEtiqueta()  {

        return codigoEtiqueta;

    }

}
