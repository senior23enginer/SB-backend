package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain;

public interface DdPedidoPickingCommandRepository  {

    int create(DdPedidoPicking entity);

    int update(DdPedidoPicking entity);

    int delete(DdPedidoPickingKey key);

}
