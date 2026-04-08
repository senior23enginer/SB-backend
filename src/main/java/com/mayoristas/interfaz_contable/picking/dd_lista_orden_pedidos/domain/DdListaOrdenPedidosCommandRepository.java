package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain;

public interface DdListaOrdenPedidosCommandRepository  {

    int create(DdListaOrdenPedidos entity);

    int update(DdListaOrdenPedidos entity);

    int delete(DdListaOrdenPedidosKey key);

}
