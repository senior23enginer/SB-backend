package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find.DdBultosFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdBultosFinderAll {

    private final DdBultosFinder finder;

    public DdBultosFinderAll(DdBultosFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdBultosFinder no puede ser null");
    }

    public List<DdBultos> execute(FindAllDdBultosQuery query) {
        Objects.requireNonNull(query, "FindAllDdBultosQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
