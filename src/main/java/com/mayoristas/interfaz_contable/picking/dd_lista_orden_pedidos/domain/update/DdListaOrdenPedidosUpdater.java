package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create.DdListaOrdenPedidosMapper;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdListaOrdenPedidosUpdater  {
    private final DdListaOrdenPedidosCommandRepository repo;
    public DdListaOrdenPedidosUpdater(DdListaOrdenPedidosCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdListaOrdenPedidosCommand c) {
        Objects.requireNonNull(c);
        DdListaOrdenPedidos a=DdListaOrdenPedidosMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdListaOrdenPedidosUnexpectedRowsException(r);
            return r;

        }
        catch(DdListaOrdenPedidosUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdListaOrdenPedidosPersistenceException(e);

        }

    }

}
