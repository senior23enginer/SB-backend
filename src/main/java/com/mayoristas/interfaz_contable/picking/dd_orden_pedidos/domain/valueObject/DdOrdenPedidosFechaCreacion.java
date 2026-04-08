package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.valueObject;

import java.time.LocalDateTime;
public class DdOrdenPedidosFechaCreacion  {
    private final LocalDateTime value;
    public DdOrdenPedidosFechaCreacion(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
