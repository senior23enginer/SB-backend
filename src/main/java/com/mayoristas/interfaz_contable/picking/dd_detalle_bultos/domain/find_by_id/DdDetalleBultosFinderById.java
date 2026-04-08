package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosKey;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.DdDetalleBultosNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddDetalleBultosFinderByIdDomain") public class DdDetalleBultosFinderById  {
    private final DdDetalleBultosQueryRepository repo;
    public DdDetalleBultosFinderById(DdDetalleBultosQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdDetalleBultos findById(FindByIdDdDetalleBultosQuery query) {
        Objects.requireNonNull(query);
        DdDetalleBultos x=repo.findById(new DdDetalleBultosKey(query.getCodigoEtiqueta(), query.getInventoryItemId()));
        if(x==null) throw new DdDetalleBultosNotFoundException(query);
        return x;

    }

}
