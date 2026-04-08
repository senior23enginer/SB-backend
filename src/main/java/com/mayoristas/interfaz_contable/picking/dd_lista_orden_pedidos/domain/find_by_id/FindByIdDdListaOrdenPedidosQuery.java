package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id;

public class FindByIdDdListaOrdenPedidosQuery  {
    private final Long codigoEmpresa;
    private final Long loCodigoDesp;
    private final String codigoLista;
    private final String codigoElemento;
    public FindByIdDdListaOrdenPedidosQuery(Long codigoEmpresa, Long loCodigoDesp, String codigoLista, String codigoElemento) {
        this.codigoEmpresa=codigoEmpresa;
        this.loCodigoDesp=loCodigoDesp;
        this.codigoLista=codigoLista;
        this.codigoElemento=codigoElemento;

    }
    public Long getCodigoEmpresa() {
        return codigoEmpresa;

    }
    public Long getLoCodigoDesp() {
        return loCodigoDesp;

    }
    public String getCodigoLista() {
        return codigoLista;

    }
    public String getCodigoElemento() {
        return codigoElemento;

    }

}
