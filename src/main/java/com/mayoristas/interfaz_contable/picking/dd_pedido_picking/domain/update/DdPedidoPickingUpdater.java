package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create.DdPedidoPickingMapper;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdPedidoPickingUpdater  {
    private final DdPedidoPickingCommandRepository repo;
    public DdPedidoPickingUpdater(DdPedidoPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdPedidoPickingCommand c) {
        Objects.requireNonNull(c);
        DdPedidoPicking a=DdPedidoPickingMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdPedidoPickingUnexpectedRowsException(r);
            return r;

        }
        catch(DdPedidoPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdPedidoPickingPersistenceException(e);

        }

    }

}
