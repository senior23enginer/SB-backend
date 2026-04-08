package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.update.DdOrdenPedidosUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdOrdenPedidosUpdaterWithoutExists {

    private final DdOrdenPedidosUpdater updater;

    public DdOrdenPedidosUpdaterWithoutExists(DdOrdenPedidosUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdOrdenPedidosUpdater no puede ser null");
    }

    public int execute(UpdateDdOrdenPedidosByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdOrdenPedidosByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
