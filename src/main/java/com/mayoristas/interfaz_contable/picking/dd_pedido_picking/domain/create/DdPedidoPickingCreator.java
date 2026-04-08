package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdPedidoPickingCreator  {
    private final DdPedidoPickingCommandRepository repo;
    public DdPedidoPickingCreator(DdPedidoPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdPedidoPicking create(CreateDdPedidoPickingCommand c) {
        Objects.requireNonNull(c);
        DdPedidoPicking a=DdPedidoPickingMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdPedidoPickingUnexpectedRowsException(r);
            return a;

        }
        catch(DdPedidoPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdPedidoPickingPersistenceException(e);

        }

    }

}
