package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id;

public class FindByIdDdTemporalOrdenPickingQuery  {
    private final Long codigoEmpresa;
    private final Long loCodigo;
    private final String sku;
    public FindByIdDdTemporalOrdenPickingQuery(Long codigoEmpresa, Long loCodigo, String sku) {
        this.codigoEmpresa=codigoEmpresa;
        this.loCodigo=loCodigo;
        this.sku=sku;

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

}
