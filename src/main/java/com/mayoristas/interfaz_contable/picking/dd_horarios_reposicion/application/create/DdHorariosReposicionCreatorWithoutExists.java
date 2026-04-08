package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionKey;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create.DdHorariosReposicionCreator;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.DdHorariosReposicionAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdHorariosReposicionCreatorWithoutExists {

    private final DdHorariosReposicionCreator creator;
    private final DdHorariosReposicionQueryRepository queryRepository;

    public DdHorariosReposicionCreatorWithoutExists(DdHorariosReposicionCreator creator, DdHorariosReposicionQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdHorariosReposicionCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdHorariosReposicionQueryRepository no puede ser null");
    }

    public DdHorariosReposicion execute(DdHorariosReposicionCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdHorariosReposicionCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdHorariosReposicionKey(command.getCodigoEmpresaDt(), command.getIdReposicion(), command.getHora())) != null) {
            throw new DdHorariosReposicionAlreadyExistsException(command.getCodigoEmpresaDt() + "|" + command.getIdReposicion() + "|" + command.getHora());
        }

        return creator.create(command);
    }
}
