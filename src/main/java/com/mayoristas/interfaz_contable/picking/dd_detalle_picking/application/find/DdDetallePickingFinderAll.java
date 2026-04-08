package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find.DdDetallePickingFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdDetallePickingFinderAll {

    private final DdDetallePickingFinder finder;

    public DdDetallePickingFinderAll(DdDetallePickingFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdDetallePickingFinder no puede ser null");
    }

    public List<DdDetallePicking> execute(FindAllDdDetallePickingQuery query) {
        Objects.requireNonNull(query, "FindAllDdDetallePickingQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
