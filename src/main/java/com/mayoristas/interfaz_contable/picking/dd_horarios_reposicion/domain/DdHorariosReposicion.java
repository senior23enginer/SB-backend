package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain;

import java.time.LocalDateTime;

public class DdHorariosReposicion  {

    private final Long codigoEmpresaDt;

    private final Long idReposicion;

    private final LocalDateTime hora;

    private final String indDeActivo;

    private final LocalDateTime fechaCreacion;

    private final String creadoPor;

    private final LocalDateTime fechaActualizacion;

    private final String actualizadoPor;

    public DdHorariosReposicion(
    Long codigoEmpresaDt,
    Long idReposicion,
    LocalDateTime hora,
    String indDeActivo,
    LocalDateTime fechaCreacion,
    String creadoPor,
    LocalDateTime fechaActualizacion,
    String actualizadoPor
    )  {

        this.codigoEmpresaDt = codigoEmpresaDt;

        this.idReposicion = idReposicion;

        this.hora = hora;

        this.indDeActivo = indDeActivo;

        this.fechaCreacion = fechaCreacion;

        this.creadoPor = creadoPor;

        this.fechaActualizacion = fechaActualizacion;

        this.actualizadoPor = actualizadoPor;

    }

    public Long getCodigoEmpresaDt()  {

        return codigoEmpresaDt;

    }

    public Long getIdReposicion()  {

        return idReposicion;

    }

    public LocalDateTime getHora()  {

        return hora;

    }

    public String getIndDeActivo()  {

        return indDeActivo;

    }

    public LocalDateTime getFechaCreacion()  {

        return fechaCreacion;

    }

    public String getCreadoPor()  {

        return creadoPor;

    }

    public LocalDateTime getFechaActualizacion()  {

        return fechaActualizacion;

    }

    public String getActualizadoPor()  {

        return actualizadoPor;

    }

}
