package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.update.DdTemporalOrdenPickingUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdTemporalOrdenPickingUpdaterWithoutExists {

    private final DdTemporalOrdenPickingUpdater updater;

    public DdTemporalOrdenPickingUpdaterWithoutExists(DdTemporalOrdenPickingUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdTemporalOrdenPickingUpdater no puede ser null");
    }

    public int execute(UpdateDdTemporalOrdenPickingByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdTemporalOrdenPickingByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
