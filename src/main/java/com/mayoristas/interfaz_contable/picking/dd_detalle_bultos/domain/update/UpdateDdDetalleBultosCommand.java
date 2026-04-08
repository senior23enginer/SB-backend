package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create.CreateDdDetalleBultosCommand;

public class UpdateDdDetalleBultosCommand extends CreateDdDetalleBultosCommand  {
    public UpdateDdDetalleBultosCommand(Long codigoEtiqueta, Long inventoryItemId, Long cantidad) {
        super(codigoEtiqueta, inventoryItemId, cantidad);

    }

}
