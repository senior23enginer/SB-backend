package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

public class FindAllDdOrdenPedidosQuery  {
    private final int page;
    private final int limit;
    public FindAllDdOrdenPedidosQuery(int page,int limit) {
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
