package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingKey;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.DdPedidoPickingNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddPedidoPickingFinderByIdDomain") public class DdPedidoPickingFinderById  {
    private final DdPedidoPickingQueryRepository repo;
    public DdPedidoPickingFinderById(DdPedidoPickingQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdPedidoPicking findById(FindByIdDdPedidoPickingQuery query) {
        Objects.requireNonNull(query);
        DdPedidoPicking x=repo.findById(new DdPedidoPickingKey(query.getIdRecvta()));
        if(x==null) throw new DdPedidoPickingNotFoundException(query);
        return x;

    }

}
