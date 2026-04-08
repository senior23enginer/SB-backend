package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create.DdOrdenPickingMapper;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdOrdenPickingUpdater  {
    private final DdOrdenPickingCommandRepository repo;
    public DdOrdenPickingUpdater(DdOrdenPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdOrdenPickingCommand c) {
        Objects.requireNonNull(c);
        DdOrdenPicking a=DdOrdenPickingMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdOrdenPickingUnexpectedRowsException(r);
            return r;

        }
        catch(DdOrdenPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdOrdenPickingPersistenceException(e);

        }

    }

}
