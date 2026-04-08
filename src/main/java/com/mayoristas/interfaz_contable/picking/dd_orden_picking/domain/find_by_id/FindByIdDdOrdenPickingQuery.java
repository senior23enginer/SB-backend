package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id;

public class FindByIdDdOrdenPickingQuery  {
    private final Long codigoEmpresa;
    private final Long loCodigo;
    private final String sku;
    public FindByIdDdOrdenPickingQuery(Long codigoEmpresa, Long loCodigo, String sku) {
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
