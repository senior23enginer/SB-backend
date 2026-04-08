package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdDetalleBultosCreator  {
    private final DdDetalleBultosCommandRepository repo;
    public DdDetalleBultosCreator(DdDetalleBultosCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdDetalleBultos create(CreateDdDetalleBultosCommand c) {
        Objects.requireNonNull(c);
        DdDetalleBultos a=DdDetalleBultosMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdDetalleBultosUnexpectedRowsException(r);
            return a;

        }
        catch(DdDetalleBultosUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdDetalleBultosPersistenceException(e);

        }

    }

}
