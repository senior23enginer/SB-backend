package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create.CreateDdDetallePickingCommand;
import java.time.LocalDateTime;

public class UpdateDdDetallePickingCommand extends CreateDdDetallePickingCommand  {
    public UpdateDdDetallePickingCommand(Long idRecvta, Long inventoryItemId, Long cantidad, LocalDateTime fechaRegistro, String usuarioRegistro, Long codigoEtiqueta) {
        super(idRecvta, inventoryItemId, cantidad, fechaRegistro, usuarioRegistro, codigoEtiqueta);

    }

}
