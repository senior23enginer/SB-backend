package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

public class FindAllDdOrdenPickingQuery  {
    private final int page;
    private final int limit;
    public FindAllDdOrdenPickingQuery(int page,int limit) {
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
