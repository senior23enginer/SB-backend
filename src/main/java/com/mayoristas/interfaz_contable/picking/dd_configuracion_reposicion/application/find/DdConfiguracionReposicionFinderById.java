package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdConfiguracionReposicionFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id.DdConfiguracionReposicionFinderById finderById;

    public DdConfiguracionReposicionFinderById(com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id.DdConfiguracionReposicionFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdConfiguracionReposicionFinderById no puede ser null");
    }

    public DdConfiguracionReposicion execute(FindByIdDdConfiguracionReposicionQuery query) {
        Objects.requireNonNull(query, "FindByIdDdConfiguracionReposicionQuery no puede ser null");
        return finderById.findById(query);
    }
}
