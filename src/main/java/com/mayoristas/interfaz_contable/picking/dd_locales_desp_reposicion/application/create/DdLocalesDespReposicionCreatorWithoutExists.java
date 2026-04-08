package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionKey;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create.DdLocalesDespReposicionCreator;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.DdLocalesDespReposicionAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdLocalesDespReposicionCreatorWithoutExists {

    private final DdLocalesDespReposicionCreator creator;
    private final DdLocalesDespReposicionQueryRepository queryRepository;

    public DdLocalesDespReposicionCreatorWithoutExists(DdLocalesDespReposicionCreator creator, DdLocalesDespReposicionQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdLocalesDespReposicionCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdLocalesDespReposicionQueryRepository no puede ser null");
    }

    public DdLocalesDespReposicion execute(DdLocalesDespReposicionCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdLocalesDespReposicionCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdLocalesDespReposicionKey(command.getCodigoEmpresaDt(), command.getIdReposicion(), command.getCodigoEmpresaDesp(), command.getLoCodigoDesp())) != null) {
            throw new DdLocalesDespReposicionAlreadyExistsException(command.getCodigoEmpresaDt() + "|" + command.getIdReposicion() + "|" + command.getCodigoEmpresaDesp() + "|" + command.getLoCodigoDesp());
        }

        return creator.create(command);
    }
}
