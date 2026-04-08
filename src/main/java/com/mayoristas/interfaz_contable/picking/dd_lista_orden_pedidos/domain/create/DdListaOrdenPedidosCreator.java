package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdListaOrdenPedidosCreator  {
    private final DdListaOrdenPedidosCommandRepository repo;
    public DdListaOrdenPedidosCreator(DdListaOrdenPedidosCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdListaOrdenPedidos create(CreateDdListaOrdenPedidosCommand c) {
        Objects.requireNonNull(c);
        DdListaOrdenPedidos a=DdListaOrdenPedidosMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdListaOrdenPedidosUnexpectedRowsException(r);
            return a;

        }
        catch(DdListaOrdenPedidosUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdListaOrdenPedidosPersistenceException(e);

        }

    }

}
