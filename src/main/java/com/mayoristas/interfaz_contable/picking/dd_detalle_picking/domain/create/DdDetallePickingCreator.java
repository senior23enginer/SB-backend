package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdDetallePickingCreator  {
    private final DdDetallePickingCommandRepository repo;
    public DdDetallePickingCreator(DdDetallePickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdDetallePicking create(CreateDdDetallePickingCommand c) {
        Objects.requireNonNull(c);
        DdDetallePicking a=DdDetallePickingMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdDetallePickingUnexpectedRowsException(r);
            return a;

        }
        catch(DdDetallePickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdDetallePickingPersistenceException(e);

        }

    }

}
