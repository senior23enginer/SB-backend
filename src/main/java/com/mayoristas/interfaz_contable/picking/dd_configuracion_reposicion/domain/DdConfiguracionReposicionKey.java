package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain;

import java.time.LocalDateTime;

public class DdConfiguracionReposicionKey  {

    private final Long codigoEmpresaDt;

    private final Long idReposicion;

    public DdConfiguracionReposicionKey(
    Long codigoEmpresaDt,
    Long idReposicion
    )  {

        this.codigoEmpresaDt = codigoEmpresaDt;

        this.idReposicion = idReposicion;

    }

    public Long getCodigoEmpresaDt()  {

        return codigoEmpresaDt;

    }

    public Long getIdReposicion()  {

        return idReposicion;

    }

}
