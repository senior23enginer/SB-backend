package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosKey;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.DdOrdenPedidosNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddOrdenPedidosFinderByIdDomain") public class DdOrdenPedidosFinderById  {
    private final DdOrdenPedidosQueryRepository repo;
    public DdOrdenPedidosFinderById(DdOrdenPedidosQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdOrdenPedidos findById(FindByIdDdOrdenPedidosQuery query) {
        Objects.requireNonNull(query);
        DdOrdenPedidos x=repo.findById(new DdOrdenPedidosKey(query.getCodigoEmpresa(), query.getLoCodigoDesp()));
        if(x==null) throw new DdOrdenPedidosNotFoundException(query);
        return x;

    }

}
