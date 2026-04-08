package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain;

import java.time.LocalDateTime;

public class DdLocalesDespReposicionKey  {

    private final Long codigoEmpresaDt;

    private final Long idReposicion;

    private final Long codigoEmpresaDesp;

    private final Long loCodigoDesp;

    public DdLocalesDespReposicionKey(
    Long codigoEmpresaDt,
    Long idReposicion,
    Long codigoEmpresaDesp,
    Long loCodigoDesp
    )  {

        this.codigoEmpresaDt = codigoEmpresaDt;

        this.idReposicion = idReposicion;

        this.codigoEmpresaDesp = codigoEmpresaDesp;

        this.loCodigoDesp = loCodigoDesp;

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

}
