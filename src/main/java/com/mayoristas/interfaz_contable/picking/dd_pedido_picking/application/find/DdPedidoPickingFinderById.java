package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdPedidoPickingFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id.DdPedidoPickingFinderById finderById;

    public DdPedidoPickingFinderById(com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id.DdPedidoPickingFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdPedidoPickingFinderById no puede ser null");
    }

    public DdPedidoPicking execute(FindByIdDdPedidoPickingQuery query) {
        Objects.requireNonNull(query, "FindByIdDdPedidoPickingQuery no puede ser null");
        return finderById.findById(query);
    }
}
