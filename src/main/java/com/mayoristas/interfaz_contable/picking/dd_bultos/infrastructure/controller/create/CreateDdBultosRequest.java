package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.create;

import java.time.LocalDateTime;

public class CreateDdBultosRequest {
    private Long codigoEtiqueta;
    private Long idRecvta;
    private String impresora;
    private LocalDateTime fechaImpresion;
    private String usuarioImpresion;
    private String indUtilizado;

    public Long getCodigoEtiqueta() {
        return codigoEtiqueta;
    }

    public void setCodigoEtiqueta(Long codigoEtiqueta) {
        this.codigoEtiqueta = codigoEtiqueta;
    }

    public Long getIdRecvta() {
        return idRecvta;
    }

    public void setIdRecvta(Long idRecvta) {
        this.idRecvta = idRecvta;
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public LocalDateTime getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(LocalDateTime fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public String getUsuarioImpresion() {
        return usuarioImpresion;
    }

    public void setUsuarioImpresion(String usuarioImpresion) {
        this.usuarioImpresion = usuarioImpresion;
    }

    public String getIndUtilizado() {
        return indUtilizado;
    }

    public void setIndUtilizado(String indUtilizado) {
        this.indUtilizado = indUtilizado;
    }
}
