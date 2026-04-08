package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find.DdTemporalOrdenPickingFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdTemporalOrdenPickingFinderAll {

    private final DdTemporalOrdenPickingFinder finder;

    public DdTemporalOrdenPickingFinderAll(DdTemporalOrdenPickingFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdTemporalOrdenPickingFinder no puede ser null");
    }

    public List<DdTemporalOrdenPicking> execute(FindAllDdTemporalOrdenPickingQuery query) {
        Objects.requireNonNull(query, "FindAllDdTemporalOrdenPickingQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
