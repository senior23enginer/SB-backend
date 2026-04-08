package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingKey;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create.DdOrdenPickingCreator;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.DdOrdenPickingAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdOrdenPickingCreatorWithoutExists {

    private final DdOrdenPickingCreator creator;
    private final DdOrdenPickingQueryRepository queryRepository;

    public DdOrdenPickingCreatorWithoutExists(DdOrdenPickingCreator creator, DdOrdenPickingQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdOrdenPickingCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdOrdenPickingQueryRepository no puede ser null");
    }

    public DdOrdenPicking execute(DdOrdenPickingCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdOrdenPickingCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdOrdenPickingKey(command.getCodigoEmpresa(), command.getLoCodigo(), command.getSku())) != null) {
            throw new DdOrdenPickingAlreadyExistsException(command.getCodigoEmpresa() + "|" + command.getLoCodigo() + "|" + command.getSku());
        }

        return creator.create(command);
    }
}
