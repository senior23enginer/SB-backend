package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdTemporalOrdenPickingFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id.DdTemporalOrdenPickingFinderById finderById;

    public DdTemporalOrdenPickingFinderById(com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id.DdTemporalOrdenPickingFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdTemporalOrdenPickingFinderById no puede ser null");
    }

    public DdTemporalOrdenPicking execute(FindByIdDdTemporalOrdenPickingQuery query) {
        Objects.requireNonNull(query, "FindByIdDdTemporalOrdenPickingQuery no puede ser null");
        return finderById.findById(query);
    }
}
