package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdOrdenPickingQuery extends com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id.FindByIdDdOrdenPickingQuery {

    public FindByIdDdOrdenPickingQuery(Long codigoEmpresa, Long loCodigo, String sku) {
        super(codigoEmpresa, loCodigo, sku);
    }
}
