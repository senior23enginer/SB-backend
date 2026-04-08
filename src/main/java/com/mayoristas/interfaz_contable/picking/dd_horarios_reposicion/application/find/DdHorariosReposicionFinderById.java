package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdHorariosReposicionFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id.DdHorariosReposicionFinderById finderById;

    public DdHorariosReposicionFinderById(com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id.DdHorariosReposicionFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdHorariosReposicionFinderById no puede ser null");
    }

    public DdHorariosReposicion execute(FindByIdDdHorariosReposicionQuery query) {
        Objects.requireNonNull(query, "FindByIdDdHorariosReposicionQuery no puede ser null");
        return finderById.findById(query);
    }
}
