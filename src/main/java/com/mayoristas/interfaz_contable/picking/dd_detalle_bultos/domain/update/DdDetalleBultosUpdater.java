package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create.DdDetalleBultosMapper;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdDetalleBultosUpdater  {
    private final DdDetalleBultosCommandRepository repo;
    public DdDetalleBultosUpdater(DdDetalleBultosCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdDetalleBultosCommand c) {
        Objects.requireNonNull(c);
        DdDetalleBultos a=DdDetalleBultosMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdDetalleBultosUnexpectedRowsException(r);
            return r;

        }
        catch(DdDetalleBultosUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdDetalleBultosPersistenceException(e);

        }

    }

}
