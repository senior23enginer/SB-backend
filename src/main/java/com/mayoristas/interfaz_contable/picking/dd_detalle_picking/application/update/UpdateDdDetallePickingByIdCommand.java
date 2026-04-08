package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.update.UpdateDdDetallePickingCommand;
import java.time.LocalDateTime;

public class UpdateDdDetallePickingByIdCommand extends UpdateDdDetallePickingCommand  {
    public UpdateDdDetallePickingByIdCommand(Long idRecvta, Long inventoryItemId, Long cantidad, LocalDateTime fechaRegistro, String usuarioRegistro, Long codigoEtiqueta) {
        super(idRecvta, inventoryItemId, cantidad, fechaRegistro, usuarioRegistro, codigoEtiqueta);

    }

}
