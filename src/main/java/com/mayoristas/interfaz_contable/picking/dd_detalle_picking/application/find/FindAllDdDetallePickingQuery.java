package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

public class FindAllDdDetallePickingQuery  {
    private final int page;
    private final int limit;
    public FindAllDdDetallePickingQuery(int page,int limit) {
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
