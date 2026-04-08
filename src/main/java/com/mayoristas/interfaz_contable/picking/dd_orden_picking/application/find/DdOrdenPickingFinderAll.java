package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find.DdOrdenPickingFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdOrdenPickingFinderAll {

    private final DdOrdenPickingFinder finder;

    public DdOrdenPickingFinderAll(DdOrdenPickingFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdOrdenPickingFinder no puede ser null");
    }

    public List<DdOrdenPicking> execute(FindAllDdOrdenPickingQuery query) {
        Objects.requireNonNull(query, "FindAllDdOrdenPickingQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
