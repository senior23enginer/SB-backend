package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain;

import java.time.LocalDateTime;

public class DdOrdenPedidosKey  {

    private final Long codigoEmpresa;

    private final Long loCodigoDesp;

    public DdOrdenPedidosKey(
    Long codigoEmpresa,
    Long loCodigoDesp
    )  {

        this.codigoEmpresa = codigoEmpresa;

        this.loCodigoDesp = loCodigoDesp;

    }

    public Long getCodigoEmpresa()  {

        return codigoEmpresa;

    }

    public Long getLoCodigoDesp()  {

        return loCodigoDesp;

    }

}
