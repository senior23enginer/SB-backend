package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain;

import java.time.LocalDateTime;

public class DdOrdenPickingKey  {

    private final Long codigoEmpresa;

    private final Long loCodigo;

    private final String sku;

    public DdOrdenPickingKey(
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
