package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create;

public class CreateDdTemporalOrdenPickingCommand  {
    private final Long codigoEmpresa;
    private final Long loCodigo;
    private final String sku;
    private final Long orden;
    private final String sep1;
    private final String sep2;
    private final String sep3;
    public CreateDdTemporalOrdenPickingCommand(Long codigoEmpresa, Long loCodigo, String sku, Long orden, String sep1, String sep2, String sep3) {
        this.codigoEmpresa=codigoEmpresa;
        this.loCodigo=loCodigo;
        this.sku=sku;
        this.orden=orden;
        this.sep1=sep1;
        this.sep2=sep2;
        this.sep3=sep3;

    }
    public Long getCodigoEmpresa() {
        return codigoEmpresa;

    }
    public Long getLoCodigo() {
        return loCodigo;

    }
    public String getSku() {
        return sku;

    }
    public Long getOrden() {
        return orden;

    }
    public String getSep1() {
        return sep1;

    }
    public String getSep2() {
        return sep2;

    }
    public String getSep3() {
        return sep3;

    }

}
