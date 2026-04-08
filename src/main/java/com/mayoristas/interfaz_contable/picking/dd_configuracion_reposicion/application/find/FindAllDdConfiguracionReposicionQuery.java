package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

public class FindAllDdConfiguracionReposicionQuery  {

    private final int page;

    private final int limit;

    public FindAllDdConfiguracionReposicionQuery(int page, int limit)  {

        this.page = page;

        this.limit = limit;

    }

    public int getPage()  {

        return page;

    }

    public int getLimit()  {

        return limit;

    }

}
