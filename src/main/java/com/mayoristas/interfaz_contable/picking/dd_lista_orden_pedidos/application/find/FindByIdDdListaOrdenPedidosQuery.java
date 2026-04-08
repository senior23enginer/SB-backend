package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdListaOrdenPedidosQuery extends com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id.FindByIdDdListaOrdenPedidosQuery {

    public FindByIdDdListaOrdenPedidosQuery(Long codigoEmpresa, Long loCodigoDesp, String codigoLista, String codigoElemento) {
        super(codigoEmpresa, loCodigoDesp, codigoLista, codigoElemento);
    }
}
