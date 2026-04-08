package com.mayoristas.interfaz_contable.picking.dd_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.update.DdBultosUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdBultosUpdaterWithoutExists {

    private final DdBultosUpdater updater;

    public DdBultosUpdaterWithoutExists(DdBultosUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdBultosUpdater no puede ser null");
    }

    public int execute(UpdateDdBultosByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdBultosByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
