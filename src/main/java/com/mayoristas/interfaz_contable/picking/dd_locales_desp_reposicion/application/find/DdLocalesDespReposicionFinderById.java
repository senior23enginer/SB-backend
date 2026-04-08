package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdLocalesDespReposicionFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id.DdLocalesDespReposicionFinderById finderById;

    public DdLocalesDespReposicionFinderById(com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id.DdLocalesDespReposicionFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdLocalesDespReposicionFinderById no puede ser null");
    }

    public DdLocalesDespReposicion execute(FindByIdDdLocalesDespReposicionQuery query) {
        Objects.requireNonNull(query, "FindByIdDdLocalesDespReposicionQuery no puede ser null");
        return finderById.findById(query);
    }
}
