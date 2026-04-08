package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

public class FindAllDdHorariosReposicionQuery  {
    private final int page;
    private final int limit;
    public FindAllDdHorariosReposicionQuery(int page,int limit) {
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
