package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject;

import java.time.LocalDateTime;
public class DdPedidoPickingFechaPicking  {
    private final LocalDateTime value;
    public DdPedidoPickingFechaPicking(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
