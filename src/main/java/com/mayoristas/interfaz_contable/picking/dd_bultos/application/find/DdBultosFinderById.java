package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdBultosFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id.DdBultosFinderById finderById;

    public DdBultosFinderById(com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id.DdBultosFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdBultosFinderById no puede ser null");
    }

    public DdBultos execute(FindByIdDdBultosQuery query) {
        Objects.requireNonNull(query, "FindByIdDdBultosQuery no puede ser null");
        return finderById.findById(query);
    }
}
