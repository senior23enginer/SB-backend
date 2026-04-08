package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdDetalleBultosQuery extends com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id.FindByIdDdDetalleBultosQuery {

    public FindByIdDdDetalleBultosQuery(Long codigoEtiqueta, Long inventoryItemId) {
        super(codigoEtiqueta, inventoryItemId);
    }
}
