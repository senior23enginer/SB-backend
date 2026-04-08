package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

public class FindAllDdLocalesDespReposicionQuery  {
    private final int page;
    private final int limit;
    public FindAllDdLocalesDespReposicionQuery(int page,int limit) {
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
