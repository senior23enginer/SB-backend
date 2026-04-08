package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

public class FindAllDdDetalleBultosQuery  {
    private final int page;
    private final int limit;
    public FindAllDdDetalleBultosQuery(int page,int limit) {
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
