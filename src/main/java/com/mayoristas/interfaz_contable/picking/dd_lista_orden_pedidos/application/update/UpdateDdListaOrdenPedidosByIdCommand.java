package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.update.UpdateDdListaOrdenPedidosCommand;
import java.time.LocalDateTime;

public class UpdateDdListaOrdenPedidosByIdCommand extends UpdateDdListaOrdenPedidosCommand  {
    public UpdateDdListaOrdenPedidosByIdCommand(Long codigoEmpresa, Long loCodigoDesp, String codigoLista, String codigoElemento, Long orgIdInv, Long ordenElemento, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresa, loCodigoDesp, codigoLista, codigoElemento, orgIdInv, ordenElemento, fechaCreacion, creadoPor);

    }

}
