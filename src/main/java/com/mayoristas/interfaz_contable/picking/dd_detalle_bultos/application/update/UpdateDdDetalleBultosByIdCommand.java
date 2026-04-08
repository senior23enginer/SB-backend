package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.update.UpdateDdDetalleBultosCommand;

public class UpdateDdDetalleBultosByIdCommand extends UpdateDdDetalleBultosCommand  {
    public UpdateDdDetalleBultosByIdCommand(Long codigoEtiqueta, Long inventoryItemId, Long cantidad) {
        super(codigoEtiqueta, inventoryItemId, cantidad);

    }

}
