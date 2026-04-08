package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosKey;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.DdListaOrdenPedidosNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddListaOrdenPedidosFinderByIdDomain") public class DdListaOrdenPedidosFinderById  {
    private final DdListaOrdenPedidosQueryRepository repo;
    public DdListaOrdenPedidosFinderById(DdListaOrdenPedidosQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdListaOrdenPedidos findById(FindByIdDdListaOrdenPedidosQuery query) {
        Objects.requireNonNull(query);
        DdListaOrdenPedidos x=repo.findById(new DdListaOrdenPedidosKey(query.getCodigoEmpresa(), query.getLoCodigoDesp(), query.getCodigoLista(), query.getCodigoElemento()));
        if(x==null) throw new DdListaOrdenPedidosNotFoundException(query);
        return x;

    }

}
