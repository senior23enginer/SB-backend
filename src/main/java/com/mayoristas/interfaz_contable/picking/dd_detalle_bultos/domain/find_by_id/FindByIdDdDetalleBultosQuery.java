package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id;

public class FindByIdDdDetalleBultosQuery  {
    private final Long codigoEtiqueta;
    private final Long inventoryItemId;
    public FindByIdDdDetalleBultosQuery(Long codigoEtiqueta, Long inventoryItemId) {
        this.codigoEtiqueta=codigoEtiqueta;
        this.inventoryItemId=inventoryItemId;

    }
    public Long getCodigoEtiqueta() {
        return codigoEtiqueta;

    }
    public Long getInventoryItemId() {
        return inventoryItemId;

    }

}
