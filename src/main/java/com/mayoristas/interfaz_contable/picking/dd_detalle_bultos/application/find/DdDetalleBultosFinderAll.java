package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find.DdDetalleBultosFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdDetalleBultosFinderAll {

    private final DdDetalleBultosFinder finder;

    public DdDetalleBultosFinderAll(DdDetalleBultosFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdDetalleBultosFinder no puede ser null");
    }

    public List<DdDetalleBultos> execute(FindAllDdDetalleBultosQuery query) {
        Objects.requireNonNull(query, "FindAllDdDetalleBultosQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
