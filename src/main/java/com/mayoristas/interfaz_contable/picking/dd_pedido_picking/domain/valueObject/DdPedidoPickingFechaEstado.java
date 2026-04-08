package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject;

import java.time.LocalDateTime;
public class DdPedidoPickingFechaEstado  {
    private final LocalDateTime value;
    public DdPedidoPickingFechaEstado(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
