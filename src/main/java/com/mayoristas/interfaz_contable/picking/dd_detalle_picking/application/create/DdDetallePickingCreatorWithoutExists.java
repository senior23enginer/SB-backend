package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingKey;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create.DdDetallePickingCreator;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.DdDetallePickingAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdDetallePickingCreatorWithoutExists {

    private final DdDetallePickingCreator creator;
    private final DdDetallePickingQueryRepository queryRepository;

    public DdDetallePickingCreatorWithoutExists(DdDetallePickingCreator creator, DdDetallePickingQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdDetallePickingCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdDetallePickingQueryRepository no puede ser null");
    }

    public DdDetallePicking execute(DdDetallePickingCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdDetallePickingCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdDetallePickingKey(command.getIdRecvta(), command.getInventoryItemId())) != null) {
            throw new DdDetallePickingAlreadyExistsException(command.getIdRecvta() + "|" + command.getInventoryItemId());
        }

        return creator.create(command);
    }
}
