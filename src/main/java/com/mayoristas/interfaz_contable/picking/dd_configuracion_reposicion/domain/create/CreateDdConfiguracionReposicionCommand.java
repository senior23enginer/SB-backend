package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create;

import java.time.LocalDateTime;
public class CreateDdConfiguracionReposicionCommand  {
    private final Long codigoEmpresaDt;
    private final Long idReposicion;
    private final String nombre;
    private final LocalDateTime fechaUltEjec;
    private final String indDeActivo;
    private final LocalDateTime fechaCreacion;
    private final String creadoPor;
    private final LocalDateTime fechaActualizacion;
    private final String actualizadoPor;
    public CreateDdConfiguracionReposicionCommand(Long codigoEmpresaDt, Long idReposicion, String nombre, LocalDateTime fechaUltEjec, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        this.codigoEmpresaDt=codigoEmpresaDt;
        this.idReposicion=idReposicion;
        this.nombre=nombre;
        this.fechaUltEjec=fechaUltEjec;
        this.indDeActivo=indDeActivo;
        this.fechaCreacion=fechaCreacion;
        this.creadoPor=creadoPor;
        this.fechaActualizacion=fechaActualizacion;
        this.actualizadoPor=actualizadoPor;

    }
    public Long getCodigoEmpresaDt() {
        return codigoEmpresaDt;

    }
    public Long getIdReposicion() {
        return idReposicion;

    }
    public String getNombre() {
        return nombre;

    }
    public LocalDateTime getFechaUltEjec() {
        return fechaUltEjec;

    }
    public String getIndDeActivo() {
        return indDeActivo;

    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;

    }
    public String getCreadoPor() {
        return creadoPor;

    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;

    }
    public String getActualizadoPor() {
        return actualizadoPor;

    }

}
