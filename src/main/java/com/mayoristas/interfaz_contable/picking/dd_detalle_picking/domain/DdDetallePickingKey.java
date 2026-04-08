package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain;

import java.time.LocalDateTime;

public class DdDetallePickingKey  {

    private final Long idRecvta;

    private final Long inventoryItemId;

    public DdDetallePickingKey(
    Long idRecvta,
    Long inventoryItemId
    )  {

        this.idRecvta = idRecvta;

        this.inventoryItemId = inventoryItemId;

    }

    public Long getIdRecvta()  {

        return idRecvta;

    }

    public Long getInventoryItemId()  {

        return inventoryItemId;

    }

}
