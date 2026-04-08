package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain;

import java.util.List;

public interface DdListaOrdenPedidosQueryRepository  {

    List<DdListaOrdenPedidos> find();

    List<DdListaOrdenPedidos> find(int limit, int offset);

    DdListaOrdenPedidos findById(DdListaOrdenPedidosKey key);

}
