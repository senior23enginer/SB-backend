package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find.DdLocalesDespReposicionFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdLocalesDespReposicionFinderAll {

    private final DdLocalesDespReposicionFinder finder;

    public DdLocalesDespReposicionFinderAll(DdLocalesDespReposicionFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdLocalesDespReposicionFinder no puede ser null");
    }

    public List<DdLocalesDespReposicion> execute(FindAllDdLocalesDespReposicionQuery query) {
        Objects.requireNonNull(query, "FindAllDdLocalesDespReposicionQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
