package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create.CreateDdListaOrdenPedidosCommand;
import java.time.LocalDateTime;

public class UpdateDdListaOrdenPedidosCommand extends CreateDdListaOrdenPedidosCommand  {
    public UpdateDdListaOrdenPedidosCommand(Long codigoEmpresa, Long loCodigoDesp, String codigoLista, String codigoElemento, Long orgIdInv, Long ordenElemento, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresa, loCodigoDesp, codigoLista, codigoElemento, orgIdInv, ordenElemento, fechaCreacion, creadoPor);

    }

}
