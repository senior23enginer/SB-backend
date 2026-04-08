package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find.DdPedidoPickingFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdPedidoPickingFinderAll {

    private final DdPedidoPickingFinder finder;

    public DdPedidoPickingFinderAll(DdPedidoPickingFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdPedidoPickingFinder no puede ser null");
    }

    public List<DdPedidoPicking> execute(FindAllDdPedidoPickingQuery query) {
        Objects.requireNonNull(query, "FindAllDdPedidoPickingQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
