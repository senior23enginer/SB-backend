package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.update.DdListaOrdenPedidosUpdater;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación para actualizar una entidad.
 */
@Service
public class DdListaOrdenPedidosUpdaterWithoutExists {

    private final DdListaOrdenPedidosUpdater updater;

    public DdListaOrdenPedidosUpdaterWithoutExists(DdListaOrdenPedidosUpdater updater) {
        this.updater = Objects.requireNonNull(updater, "DdListaOrdenPedidosUpdater no puede ser null");
    }

    public int execute(UpdateDdListaOrdenPedidosByIdCommand command) {
        Objects.requireNonNull(command, "UpdateDdListaOrdenPedidosByIdCommand no puede ser null");
        return updater.execute(command);
    }
}
