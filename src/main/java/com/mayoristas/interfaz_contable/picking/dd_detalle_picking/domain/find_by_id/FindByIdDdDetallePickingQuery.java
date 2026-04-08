package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id;

public class FindByIdDdDetallePickingQuery  {
    private final Long idRecvta;
    private final Long inventoryItemId;
    public FindByIdDdDetallePickingQuery(Long idRecvta, Long inventoryItemId) {
        this.idRecvta=idRecvta;
        this.inventoryItemId=inventoryItemId;

    }
    public Long getIdRecvta() {
        return idRecvta;

    }
    public Long getInventoryItemId() {
        return inventoryItemId;

    }

}
