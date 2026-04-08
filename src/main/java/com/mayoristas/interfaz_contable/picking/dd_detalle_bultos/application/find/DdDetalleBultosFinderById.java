package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdDetalleBultosFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id.DdDetalleBultosFinderById finderById;

    public DdDetalleBultosFinderById(com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id.DdDetalleBultosFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdDetalleBultosFinderById no puede ser null");
    }

    public DdDetalleBultos execute(FindByIdDdDetalleBultosQuery query) {
        Objects.requireNonNull(query, "FindByIdDdDetalleBultosQuery no puede ser null");
        return finderById.findById(query);
    }
}
