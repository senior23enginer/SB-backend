package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain;

import java.util.List;

public interface DdOrdenPedidosQueryRepository  {

    List<DdOrdenPedidos> find();

    List<DdOrdenPedidos> find(int limit, int offset);

    DdOrdenPedidos findById(DdOrdenPedidosKey key);

}
