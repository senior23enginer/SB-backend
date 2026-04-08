package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdListaOrdenPedidosFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id.DdListaOrdenPedidosFinderById finderById;

    public DdListaOrdenPedidosFinderById(com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id.DdListaOrdenPedidosFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdListaOrdenPedidosFinderById no puede ser null");
    }

    public DdListaOrdenPedidos execute(FindByIdDdListaOrdenPedidosQuery query) {
        Objects.requireNonNull(query, "FindByIdDdListaOrdenPedidosQuery no puede ser null");
        return finderById.findById(query);
    }
}
