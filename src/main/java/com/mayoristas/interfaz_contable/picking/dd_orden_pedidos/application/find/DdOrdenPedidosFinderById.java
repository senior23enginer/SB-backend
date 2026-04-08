package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdOrdenPedidosFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id.DdOrdenPedidosFinderById finderById;

    public DdOrdenPedidosFinderById(com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id.DdOrdenPedidosFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdOrdenPedidosFinderById no puede ser null");
    }

    public DdOrdenPedidos execute(FindByIdDdOrdenPedidosQuery query) {
        Objects.requireNonNull(query, "FindByIdDdOrdenPedidosQuery no puede ser null");
        return finderById.findById(query);
    }
}
