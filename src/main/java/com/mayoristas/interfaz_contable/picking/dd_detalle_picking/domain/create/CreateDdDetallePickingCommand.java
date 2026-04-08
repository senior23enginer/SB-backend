package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create;

import java.time.LocalDateTime;
public class CreateDdDetallePickingCommand  {
    private final Long idRecvta;
    private final Long inventoryItemId;
    private final Long cantidad;
    private final LocalDateTime fechaRegistro;
    private final String usuarioRegistro;
    private final Long codigoEtiqueta;
    public CreateDdDetallePickingCommand(Long idRecvta, Long inventoryItemId, Long cantidad, LocalDateTime fechaRegistro, String usuarioRegistro, Long codigoEtiqueta) {
        this.idRecvta=idRecvta;
        this.inventoryItemId=inventoryItemId;
        this.cantidad=cantidad;
        this.fechaRegistro=fechaRegistro;
        this.usuarioRegistro=usuarioRegistro;
        this.codigoEtiqueta=codigoEtiqueta;

    }
    public Long getIdRecvta() {
        return idRecvta;

    }
    public Long getInventoryItemId() {
        return inventoryItemId;

    }
    public Long getCantidad() {
        return cantidad;

    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;

    }
    public String getUsuarioRegistro() {
        return usuarioRegistro;

    }
    public Long getCodigoEtiqueta() {
        return codigoEtiqueta;

    }

}
