package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

public class FindAllDdPedidoPickingQuery  {
    private final int page;
    private final int limit;
    public FindAllDdPedidoPickingQuery(int page,int limit) {
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
