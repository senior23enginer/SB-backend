package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id;

public class FindByIdDdBultosQuery  {

    private final Long codigoEtiqueta;

    public FindByIdDdBultosQuery(Long codigoEtiqueta)  {

        this.codigoEtiqueta = codigoEtiqueta;

    }

    public Long getCodigoEtiqueta()  {

        return codigoEtiqueta;

    }

}
