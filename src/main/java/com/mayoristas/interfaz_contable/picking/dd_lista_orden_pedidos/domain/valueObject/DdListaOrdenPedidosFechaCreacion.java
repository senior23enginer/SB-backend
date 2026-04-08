package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.valueObject;

import java.time.LocalDateTime;
public class DdListaOrdenPedidosFechaCreacion  {
    private final LocalDateTime value;
    public DdListaOrdenPedidosFechaCreacion(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
