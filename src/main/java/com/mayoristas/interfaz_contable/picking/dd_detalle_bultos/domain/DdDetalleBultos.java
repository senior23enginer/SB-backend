package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain;

import java.time.LocalDateTime;

public class DdDetalleBultos  {

    private final Long codigoEtiqueta;

    private final Long inventoryItemId;

    private final Long cantidad;

    public DdDetalleBultos(
    Long codigoEtiqueta,
    Long inventoryItemId,
    Long cantidad
    )  {

        this.codigoEtiqueta = codigoEtiqueta;

        this.inventoryItemId = inventoryItemId;

        this.cantidad = cantidad;

    }

    public Long getCodigoEtiqueta()  {

        return codigoEtiqueta;

    }

    public Long getInventoryItemId()  {

        return inventoryItemId;

    }

    public Long getCantidad()  {

        return cantidad;

    }

}
