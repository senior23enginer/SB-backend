package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain;

public interface DdOrdenPedidosCommandRepository  {

    int create(DdOrdenPedidos entity);

    int update(DdOrdenPedidos entity);

    int delete(DdOrdenPedidosKey key);

}
