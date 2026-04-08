package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.update.DdConfiguracionReposicionUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdConfiguracionReposicionUpdaterWithoutExists {

    private final DdConfiguracionReposicionUpdater updater;

    public DdConfiguracionReposicionUpdaterWithoutExists(DdConfiguracionReposicionUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdConfiguracionReposicionUpdater no puede ser null");
    }

    public int execute(UpdateDdConfiguracionReposicionByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdConfiguracionReposicionByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
