package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

public class FindAllDdListaOrdenPedidosQuery  {
    private final int page;
    private final int limit;
    public FindAllDdListaOrdenPedidosQuery(int page,int limit) {
        this.page=page;
        this.limit=limit;

    }
    public int getPage() {
        return page;

    }
    public int getLimit() {
        return limit;

    }

}
