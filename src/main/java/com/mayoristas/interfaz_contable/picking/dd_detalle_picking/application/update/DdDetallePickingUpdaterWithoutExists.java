package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.update.DdDetallePickingUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdDetallePickingUpdaterWithoutExists {

    private final DdDetallePickingUpdater updater;

    public DdDetallePickingUpdaterWithoutExists(DdDetallePickingUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdDetallePickingUpdater no puede ser null");
    }

    public int execute(UpdateDdDetallePickingByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdDetallePickingByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
