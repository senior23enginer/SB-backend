package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find.DdListaOrdenPedidosFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdListaOrdenPedidosFinderAll {

    private final DdListaOrdenPedidosFinder finder;

    public DdListaOrdenPedidosFinderAll(DdListaOrdenPedidosFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdListaOrdenPedidosFinder no puede ser null");
    }

    public List<DdListaOrdenPedidos> execute(FindAllDdListaOrdenPedidosQuery query) {
        Objects.requireNonNull(query, "FindAllDdListaOrdenPedidosQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
