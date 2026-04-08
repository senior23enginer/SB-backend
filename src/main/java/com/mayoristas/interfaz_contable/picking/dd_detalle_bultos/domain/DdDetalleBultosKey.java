package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain;

import java.time.LocalDateTime;

public class DdDetalleBultosKey  {

    private final Long codigoEtiqueta;

    private final Long inventoryItemId;

    public DdDetalleBultosKey(
    Long codigoEtiqueta,
    Long inventoryItemId
    )  {

        this.codigoEtiqueta = codigoEtiqueta;

        this.inventoryItemId = inventoryItemId;

    }

    public Long getCodigoEtiqueta()  {

        return codigoEtiqueta;

    }

    public Long getInventoryItemId()  {

        return inventoryItemId;

    }

}
