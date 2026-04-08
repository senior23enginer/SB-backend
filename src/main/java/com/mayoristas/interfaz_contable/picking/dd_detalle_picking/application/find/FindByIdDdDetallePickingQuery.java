package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdDetallePickingQuery extends com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id.FindByIdDdDetallePickingQuery {

    public FindByIdDdDetallePickingQuery(Long idRecvta, Long inventoryItemId) {
        super(idRecvta, inventoryItemId);
    }
}
