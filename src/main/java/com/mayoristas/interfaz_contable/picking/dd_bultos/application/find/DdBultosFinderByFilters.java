package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find.DdBultosFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DdBultosFinderByFilters {

    private final DdBultosFinder finder;

    public DdBultosFinderByFilters(DdBultosFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdBultosFinder no puede ser null");
    }

    public List<DdBultos> execute(FindDdBultosByFiltersQuery query) {
        Objects.requireNonNull(query, "FindDdBultosByFiltersQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findByFilters(
                query.getIdRecvta(),
                query.getImpresora(),
                query.getUsuarioImpresion(),
                query.getIndUtilizado(),
                limit,
                offset
        );
    }
}
