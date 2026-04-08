package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain;

import java.util.List;

public interface DdPedidoPickingQueryRepository  {

    List<DdPedidoPicking> find();

    List<DdPedidoPicking> find(int limit, int offset);

    DdPedidoPicking findById(DdPedidoPickingKey key);

}
