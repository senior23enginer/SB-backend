package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
public final class DdListaOrdenPedidosMapper  {
    private DdListaOrdenPedidosMapper() {

    }
    public static DdListaOrdenPedidos from(CreateDdListaOrdenPedidosCommand command) {
        return new DdListaOrdenPedidos(command.getCodigoEmpresa(), command.getLoCodigoDesp(), command.getCodigoLista(), command.getCodigoElemento(), command.getOrgIdInv(), command.getOrdenElemento(), command.getFechaCreacion(), command.getCreadoPor());

    }

}
