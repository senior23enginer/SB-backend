package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.update.DdLocalesDespReposicionUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdLocalesDespReposicionUpdaterWithoutExists {

    private final DdLocalesDespReposicionUpdater updater;

    public DdLocalesDespReposicionUpdaterWithoutExists(DdLocalesDespReposicionUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdLocalesDespReposicionUpdater no puede ser null");
    }

    public int execute(UpdateDdLocalesDespReposicionByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdLocalesDespReposicionByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
