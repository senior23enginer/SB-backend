package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain;

import java.time.LocalDateTime;

public class DdTemporalOrdenPickingKey  {

    private final Long codigoEmpresa;

    private final Long loCodigo;

    private final String sku;

    public DdTemporalOrdenPickingKey(
    Long codigoEmpresa,
    Long loCodigo,
    String sku
    )  {

        this.codigoEmpresa = codigoEmpresa;

        this.loCodigo = loCodigo;

        this.sku = sku;

    }

    public Long getCodigoEmpresa()  {

        return codigoEmpresa;

    }

    public Long getLoCodigo()  {

        return loCodigo;

    }

    public String getSku()  {

        return sku;

    }

}
