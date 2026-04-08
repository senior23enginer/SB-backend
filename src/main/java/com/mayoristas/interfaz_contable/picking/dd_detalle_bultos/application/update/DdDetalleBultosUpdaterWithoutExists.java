package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.update.DdDetalleBultosUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdDetalleBultosUpdaterWithoutExists {

    private final DdDetalleBultosUpdater updater;

    public DdDetalleBultosUpdaterWithoutExists(DdDetalleBultosUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdDetalleBultosUpdater no puede ser null");
    }

    public int execute(UpdateDdDetalleBultosByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdDetalleBultosByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
