package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

public class FindAllDdBultosQuery  {

    private final int page;

    private final int limit;

    public FindAllDdBultosQuery(int page, int limit)  {

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
