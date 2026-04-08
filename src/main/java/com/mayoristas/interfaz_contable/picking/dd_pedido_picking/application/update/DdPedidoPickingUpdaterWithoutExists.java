package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.update.DdPedidoPickingUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdPedidoPickingUpdaterWithoutExists {

    private final DdPedidoPickingUpdater updater;

    public DdPedidoPickingUpdaterWithoutExists(DdPedidoPickingUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdPedidoPickingUpdater no puede ser null");
    }

    public int execute(UpdateDdPedidoPickingByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdPedidoPickingByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
