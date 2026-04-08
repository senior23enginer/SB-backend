package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id;

public class FindByIdDdPedidoPickingQuery  {
    private final Long idRecvta;
    public FindByIdDdPedidoPickingQuery(Long idRecvta) {
        this.idRecvta=idRecvta;

    }
    public Long getIdRecvta() {
        return idRecvta;

    }

}
