package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create.CreateDdDetallePickingCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking}
 * validando previamente que no exista por llave primaria.
 */
public class DdDetallePickingCreateWithoutExistsCommand extends CreateDdDetallePickingCommand {

    public DdDetallePickingCreateWithoutExistsCommand(Long idRecvta, Long inventoryItemId, Long cantidad, LocalDateTime fechaRegistro, String usuarioRegistro, Long codigoEtiqueta) {
        super(idRecvta, inventoryItemId, cantidad, fechaRegistro, usuarioRegistro, codigoEtiqueta);
    }
}
