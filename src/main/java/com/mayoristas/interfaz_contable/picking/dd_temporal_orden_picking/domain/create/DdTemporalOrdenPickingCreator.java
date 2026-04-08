package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdTemporalOrdenPickingCreator  {
    private final DdTemporalOrdenPickingCommandRepository repo;
    public DdTemporalOrdenPickingCreator(DdTemporalOrdenPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdTemporalOrdenPicking create(CreateDdTemporalOrdenPickingCommand c) {
        Objects.requireNonNull(c);
        DdTemporalOrdenPicking a=DdTemporalOrdenPickingMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdTemporalOrdenPickingUnexpectedRowsException(r);
            return a;

        }
        catch(DdTemporalOrdenPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdTemporalOrdenPickingPersistenceException(e);

        }

    }

}
