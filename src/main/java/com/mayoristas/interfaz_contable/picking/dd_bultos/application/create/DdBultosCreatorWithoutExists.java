package com.mayoristas.interfaz_contable.picking.dd_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosKey;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create.DdBultosCreator;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdBultosCreatorWithoutExists {

    private final DdBultosCreator creator;
    private final DdBultosQueryRepository queryRepository;

    public DdBultosCreatorWithoutExists(DdBultosCreator creator, DdBultosQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdBultosCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdBultosQueryRepository no puede ser null");
    }

    public DdBultos execute(DdBultosCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdBultosCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdBultosKey(command.getCodigoEtiqueta())) != null) {
            throw new DdBultosAlreadyExistsException(command.getCodigoEtiqueta());
        }

        return creator.create(command);
    }
}
