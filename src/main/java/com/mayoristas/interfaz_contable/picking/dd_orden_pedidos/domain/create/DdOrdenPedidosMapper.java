package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
public final class DdOrdenPedidosMapper  {
    private DdOrdenPedidosMapper() {

    }
    public static DdOrdenPedidos from(CreateDdOrdenPedidosCommand command) {
        return new DdOrdenPedidos(command.getCodigoEmpresa(), command.getLoCodigoDesp(), command.getCheckComuna(), command.getCheckMarca(), command.getCheckProducto(), command.getIndAndOrProd(), command.getIndIncExc(), command.getCheckStock(), command.getSinStock(), command.getConStock(), command.getCheckCantProd(), command.getCantProdDesde(), command.getCantProdHasta(), command.getCheckPrecio(), command.getPrecioDesde(), command.getPrecioHasta(), command.getFechaCreacion(), command.getCreadoPor(), command.getFechaActualicacion(), command.getActualizadoPor());

    }

}
