package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.find;

public class FindAllDdTemporalOrdenPickingQuery {
    private final int page;
    private final int limit;

    public FindAllDdTemporalOrdenPickingQuery(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }
}
