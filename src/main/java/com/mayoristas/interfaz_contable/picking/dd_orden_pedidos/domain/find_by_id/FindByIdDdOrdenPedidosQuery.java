package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id;

public class FindByIdDdOrdenPedidosQuery  {
    private final Long codigoEmpresa;
    private final Long loCodigoDesp;
    public FindByIdDdOrdenPedidosQuery(Long codigoEmpresa, Long loCodigoDesp) {
        this.codigoEmpresa=codigoEmpresa;
        this.loCodigoDesp=loCodigoDesp;

    }
    public Long getCodigoEmpresa() {
        return codigoEmpresa;

    }
    public Long getLoCodigoDesp() {
        return loCodigoDesp;

    }

}
