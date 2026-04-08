package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingKey;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create.DdPedidoPickingCreator;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.DdPedidoPickingAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdPedidoPickingCreatorWithoutExists {

    private final DdPedidoPickingCreator creator;
    private final DdPedidoPickingQueryRepository queryRepository;

    public DdPedidoPickingCreatorWithoutExists(DdPedidoPickingCreator creator, DdPedidoPickingQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdPedidoPickingCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdPedidoPickingQueryRepository no puede ser null");
    }

    public DdPedidoPicking execute(DdPedidoPickingCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdPedidoPickingCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdPedidoPickingKey(command.getIdRecvta())) != null) {
            throw new DdPedidoPickingAlreadyExistsException(command.getIdRecvta());
        }

        return creator.create(command);
    }
}
