package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create.DdDetallePickingMapper;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdDetallePickingUpdater  {
    private final DdDetallePickingCommandRepository repo;
    public DdDetallePickingUpdater(DdDetallePickingCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdDetallePickingCommand c) {
        Objects.requireNonNull(c);
        DdDetallePicking a=DdDetallePickingMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdDetallePickingUnexpectedRowsException(r);
            return r;

        }
        catch(DdDetallePickingUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdDetallePickingPersistenceException(e);

        }

    }

}
