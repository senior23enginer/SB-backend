package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdBultosQuery extends com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id.FindByIdDdBultosQuery {

    public FindByIdDdBultosQuery(Long codigoEtiqueta) {
        super(codigoEtiqueta);
    }
}
