package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create;

public class CreateDdDetalleBultosCommand  {
    private final Long codigoEtiqueta;
    private final Long inventoryItemId;
    private final Long cantidad;
    public CreateDdDetalleBultosCommand(Long codigoEtiqueta, Long inventoryItemId, Long cantidad) {
        this.codigoEtiqueta=codigoEtiqueta;
        this.inventoryItemId=inventoryItemId;
        this.cantidad=cantidad;

    }
    public Long getCodigoEtiqueta() {
        return codigoEtiqueta;

    }
    public Long getInventoryItemId() {
        return inventoryItemId;

    }
    public Long getCantidad() {
        return cantidad;

    }

}
