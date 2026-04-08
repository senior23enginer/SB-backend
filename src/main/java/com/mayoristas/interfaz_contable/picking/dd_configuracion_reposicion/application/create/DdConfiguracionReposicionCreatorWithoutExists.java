package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionKey;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create.DdConfiguracionReposicionCreator;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.DdConfiguracionReposicionAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdConfiguracionReposicionCreatorWithoutExists {

    private final DdConfiguracionReposicionCreator creator;
    private final DdConfiguracionReposicionQueryRepository queryRepository;

    public DdConfiguracionReposicionCreatorWithoutExists(DdConfiguracionReposicionCreator creator, DdConfiguracionReposicionQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdConfiguracionReposicionCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdConfiguracionReposicionQueryRepository no puede ser null");
    }

    public DdConfiguracionReposicion execute(DdConfiguracionReposicionCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdConfiguracionReposicionCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdConfiguracionReposicionKey(command.getCodigoEmpresaDt(), command.getIdReposicion())) != null) {
            throw new DdConfiguracionReposicionAlreadyExistsException(command.getCodigoEmpresaDt() + "|" + command.getIdReposicion());
        }

        return creator.create(command);
    }
}
