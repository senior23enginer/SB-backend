package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain;

import java.time.LocalDateTime;

public class DdLocalesDespReposicion  {

    private final Long codigoEmpresaDt;

    private final Long idReposicion;

    private final Long codigoEmpresaDesp;

    private final Long loCodigoDesp;

    private final LocalDateTime fechaCreacion;

    private final String creadoPor;

    public DdLocalesDespReposicion(
    Long codigoEmpresaDt,
    Long idReposicion,
    Long codigoEmpresaDesp,
    Long loCodigoDesp,
    LocalDateTime fechaCreacion,
    String creadoPor
    )  {

        this.codigoEmpresaDt = codigoEmpresaDt;

        this.idReposicion = idReposicion;

        this.codigoEmpresaDesp = codigoEmpresaDesp;

        this.loCodigoDesp = loCodigoDesp;

        this.fechaCreacion = fechaCreacion;

        this.creadoPor = creadoPor;

    }

    public Long getCodigoEmpresaDt()  {

        return codigoEmpresaDt;

    }

    public Long getIdReposicion()  {

        return idReposicion;

    }

    public Long getCodigoEmpresaDesp()  {

        return codigoEmpresaDesp;

    }

    public Long getLoCodigoDesp()  {

        return loCodigoDesp;

    }

    public LocalDateTime getFechaCreacion()  {

        return fechaCreacion;

    }

    public String getCreadoPor()  {

        return creadoPor;

    }

}
