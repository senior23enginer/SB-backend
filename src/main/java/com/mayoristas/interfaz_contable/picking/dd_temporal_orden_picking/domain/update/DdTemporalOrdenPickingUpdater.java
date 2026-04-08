package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create.DdTemporalOrdenPickingMapper;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdTemporalOrdenPickingUpdater  {
    private final DdTemporalOrdenPickingCommandRepository repo;
    public DdTemporalOrdenPickingUpdater(DdTemporalOrdenPickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdTemporalOrdenPickingCommand c) {
        Objects.requireNonNull(c);
        DdTemporalOrdenPicking a=DdTemporalOrdenPickingMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdTemporalOrdenPickingUnexpectedRowsException(r);
            return r;

        }
        catch(DdTemporalOrdenPickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdTemporalOrdenPickingPersistenceException(e);

        }

    }

}
