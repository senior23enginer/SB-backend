package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain;

import java.time.LocalDateTime;

public class DdListaOrdenPedidos  {

    private final Long codigoEmpresa;

    private final Long loCodigoDesp;

    private final String codigoLista;

    private final String codigoElemento;

    private final Long orgIdInv;

    private final Long ordenElemento;

    private final LocalDateTime fechaCreacion;

    private final String creadoPor;

    public DdListaOrdenPedidos(
    Long codigoEmpresa,
    Long loCodigoDesp,
    String codigoLista,
    String codigoElemento,
    Long orgIdInv,
    Long ordenElemento,
    LocalDateTime fechaCreacion,
    String creadoPor
    )  {

        this.codigoEmpresa = codigoEmpresa;

        this.loCodigoDesp = loCodigoDesp;

        this.codigoLista = codigoLista;

        this.codigoElemento = codigoElemento;

        this.orgIdInv = orgIdInv;

        this.ordenElemento = ordenElemento;

        this.fechaCreacion = fechaCreacion;

        this.creadoPor = creadoPor;

    }

    public Long getCodigoEmpresa()  {

        return codigoEmpresa;

    }

    public Long getLoCodigoDesp()  {

        return loCodigoDesp;

    }

    public String getCodigoLista()  {

        return codigoLista;

    }

    public String getCodigoElemento()  {

        return codigoElemento;

    }

    public Long getOrgIdInv()  {

        return orgIdInv;

    }

    public Long getOrdenElemento()  {

        return ordenElemento;

    }

    public LocalDateTime getFechaCreacion()  {

        return fechaCreacion;

    }

    public String getCreadoPor()  {

        return creadoPor;

    }

}
