package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdOrdenPedidosQuery extends com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id.FindByIdDdOrdenPedidosQuery {

    public FindByIdDdOrdenPedidosQuery(Long codigoEmpresa, Long loCodigoDesp) {
        super(codigoEmpresa, loCodigoDesp);
    }
}
