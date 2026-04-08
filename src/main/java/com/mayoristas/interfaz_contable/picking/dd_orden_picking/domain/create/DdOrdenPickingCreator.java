package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdOrdenPickingCreator  {
    private final DdOrdenPickingCommandRepository repo;
    public DdOrdenPickingCreator(DdOrdenPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdOrdenPicking create(CreateDdOrdenPickingCommand c) {
        Objects.requireNonNull(c);
        DdOrdenPicking a=DdOrdenPickingMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdOrdenPickingUnexpectedRowsException(r);
            return a;

        }
        catch(DdOrdenPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdOrdenPickingPersistenceException(e);

        }

    }

}
