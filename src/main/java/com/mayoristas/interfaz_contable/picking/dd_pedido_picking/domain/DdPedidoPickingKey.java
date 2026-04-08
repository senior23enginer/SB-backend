package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain;

import java.time.LocalDateTime;

public class DdPedidoPickingKey  {

    private final Long idRecvta;

    public DdPedidoPickingKey(
    Long idRecvta
    )  {

        this.idRecvta = idRecvta;

    }

    public Long getIdRecvta()  {

        return idRecvta;

    }

}
