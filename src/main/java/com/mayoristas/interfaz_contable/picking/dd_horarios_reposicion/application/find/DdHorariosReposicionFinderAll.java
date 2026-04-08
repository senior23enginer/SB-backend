package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find.DdHorariosReposicionFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdHorariosReposicionFinderAll {

    private final DdHorariosReposicionFinder finder;

    public DdHorariosReposicionFinderAll(DdHorariosReposicionFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdHorariosReposicionFinder no puede ser null");
    }

    public List<DdHorariosReposicion> execute(FindAllDdHorariosReposicionQuery query) {
        Objects.requireNonNull(query, "FindAllDdHorariosReposicionQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
