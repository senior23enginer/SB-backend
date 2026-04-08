package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.update.DdHorariosReposicionUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdHorariosReposicionUpdaterWithoutExists {

    private final DdHorariosReposicionUpdater updater;

    public DdHorariosReposicionUpdaterWithoutExists(DdHorariosReposicionUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdHorariosReposicionUpdater no puede ser null");
    }

    public int execute(UpdateDdHorariosReposicionByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdHorariosReposicionByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
