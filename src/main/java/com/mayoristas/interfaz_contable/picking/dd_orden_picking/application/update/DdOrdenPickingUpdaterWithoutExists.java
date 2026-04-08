package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.update.DdOrdenPickingUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdOrdenPickingUpdaterWithoutExists {

    private final DdOrdenPickingUpdater updater;

    public DdOrdenPickingUpdaterWithoutExists(DdOrdenPickingUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdOrdenPickingUpdater no puede ser null");
    }

    public int execute(UpdateDdOrdenPickingByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdOrdenPickingByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
