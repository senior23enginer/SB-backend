package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdOrdenPedidosCreator  {
    private final DdOrdenPedidosCommandRepository repo;
    public DdOrdenPedidosCreator(DdOrdenPedidosCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdOrdenPedidos create(CreateDdOrdenPedidosCommand c) {
        Objects.requireNonNull(c);
        DdOrdenPedidos a=DdOrdenPedidosMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdOrdenPedidosUnexpectedRowsException(r);
            return a;

        }
        catch(DdOrdenPedidosUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdOrdenPedidosPersistenceException(e);

        }

    }

}
