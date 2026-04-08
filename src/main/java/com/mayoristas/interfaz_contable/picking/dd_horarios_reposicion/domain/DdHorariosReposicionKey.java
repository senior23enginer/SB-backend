package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain;

import java.time.LocalDateTime;

public class DdHorariosReposicionKey  {

    private final Long codigoEmpresaDt;

    private final Long idReposicion;

    private final LocalDateTime hora;

    public DdHorariosReposicionKey(
    Long codigoEmpresaDt,
    Long idReposicion,
    LocalDateTime hora
    )  {

        this.codigoEmpresaDt = codigoEmpresaDt;

        this.idReposicion = idReposicion;

        this.hora = hora;

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

}
