package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create.CreateDdListaOrdenPedidosCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos}
 * validando previamente que no exista por llave primaria.
 */
public class DdListaOrdenPedidosCreateWithoutExistsCommand extends CreateDdListaOrdenPedidosCommand {

    public DdListaOrdenPedidosCreateWithoutExistsCommand(Long codigoEmpresa, Long loCodigoDesp, String codigoLista, String codigoElemento, Long orgIdInv, Long ordenElemento, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresa, loCodigoDesp, codigoLista, codigoElemento, orgIdInv, ordenElemento, fechaCreacion, creadoPor);
    }
}
