package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find.DdConfiguracionReposicionFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Caso de uso de aplicación para listar entidades de forma paginada.
 */
@Service
public class DdConfiguracionReposicionFinderAll {

    private final DdConfiguracionReposicionFinder finder;

    public DdConfiguracionReposicionFinderAll(DdConfiguracionReposicionFinder finder) {
        this.finder = Objects.requireNonNull(finder, "DdConfiguracionReposicionFinder no puede ser null");
    }

    public List<DdConfiguracionReposicion> execute(FindAllDdConfiguracionReposicionQuery query) {
        Objects.requireNonNull(query, "FindAllDdConfiguracionReposicionQuery no puede ser null");

        int page = query.getPage() <= 0 ? 1 : query.getPage();
        int limit = query.getLimit() <= 0 ? 20 : query.getLimit();
        int offset = (page - 1) * limit;

        return finder.findAll(limit, offset);
    }
}
