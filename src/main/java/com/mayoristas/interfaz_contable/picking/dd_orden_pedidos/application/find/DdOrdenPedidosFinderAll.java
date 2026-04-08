package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find.DdOrdenPedidosFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdOrdenPedidosFinderAll {

    private final DdOrdenPedidosFinder finder;

    public DdOrdenPedidosFinderAll(DdOrdenPedidosFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdOrdenPedidosFinder no puede ser null");
    }

    public List<DdOrdenPedidos> execute(FindAllDdOrdenPedidosQuery query) {
        Objects.requireNonNull(query, "FindAllDdOrdenPedidosQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
