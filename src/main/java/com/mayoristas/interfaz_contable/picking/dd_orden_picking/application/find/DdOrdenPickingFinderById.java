package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdOrdenPickingFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id.DdOrdenPickingFinderById finderById;

    public DdOrdenPickingFinderById(com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id.DdOrdenPickingFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdOrdenPickingFinderById no puede ser null");
    }

    public DdOrdenPicking execute(FindByIdDdOrdenPickingQuery query) {
        Objects.requireNonNull(query, "FindByIdDdOrdenPickingQuery no puede ser null");
        return finderById.findById(query);
    }
}
