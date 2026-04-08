package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create;

import java.time.LocalDateTime;

public class CreateDdPedidoPickingCommand  {
    private final Long idRecvta;
    private final String estado;
    private final LocalDateTime fechaEstado;
    private final String usuarioEstado;
    private final LocalDateTime fechaPicking;
    private final String usuarioPicking;
    private final Long codigoEmpresa;
    private final Long loCodigo;
    public CreateDdPedidoPickingCommand(Long idRecvta, String estado, LocalDateTime fechaEstado, String usuarioEstado, LocalDateTime fechaPicking, String usuarioPicking, Long codigoEmpresa, Long loCodigo) {
        this.idRecvta=idRecvta;
        this.estado=estado;
        this.fechaEstado=fechaEstado;
        this.usuarioEstado=usuarioEstado;
        this.fechaPicking=fechaPicking;
        this.usuarioPicking=usuarioPicking;
        this.codigoEmpresa=codigoEmpresa;
        this.loCodigo=loCodigo;

    }
    public Long getIdRecvta() {
        return idRecvta;

    }
    public String getEstado() {
        return estado;

    }
    public LocalDateTime getFechaEstado() {
        return fechaEstado;

    }
    public String getUsuarioEstado() {
        return usuarioEstado;

    }
    public LocalDateTime getFechaPicking() {
        return fechaPicking;

    }
    public String getUsuarioPicking() {
        return usuarioPicking;

    }
    public Long getCodigoEmpresa() {
        return codigoEmpresa;

    }
    public Long getLoCodigo() {
        return loCodigo;

    }

}
