package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create.DdOrdenPedidosMapper;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DdOrdenPedidosUpdater  {

    private final DdOrdenPedidosCommandRepository repo;

    public DdOrdenPedidosUpdater(DdOrdenPedidosCommandRepository repo)  {

        this.repo = Objects.requireNonNull(repo);

    }

    public int execute(UpdateDdOrdenPedidosCommand c)  {

        Objects.requireNonNull(c);

        DdOrdenPedidos a = DdOrdenPedidosMapper.from(c);

        try  {

            int r = repo.update(a);

            if (r != 1) throw new DdOrdenPedidosUnexpectedRowsException(r);

            return r;

        }
        catch (DdOrdenPedidosUnexpectedRowsException e)  {

            throw e;

        }
        catch (Exception e)  {

            throw new DdOrdenPedidosPersistenceException(e);

        }

    }

}
