package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para buscar una entidad por id.
 */
@Service
public class DdDetallePickingFinderById {

    private final com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id.DdDetallePickingFinderById finderById;

    public DdDetallePickingFinderById(com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id.DdDetallePickingFinderById finderById) {
        this.finderById = Objects.requireNonNull(finderById, "DdDetallePickingFinderById no puede ser null");
    }

    public DdDetallePicking execute(FindByIdDdDetallePickingQuery query) {
        Objects.requireNonNull(query, "FindByIdDdDetallePickingQuery no puede ser null");
        return finderById.findById(query);
    }
}
