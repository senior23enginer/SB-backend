package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingKey;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.DdOrdenPickingNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddOrdenPickingFinderByIdDomain") public class DdOrdenPickingFinderById  {
    private final DdOrdenPickingQueryRepository repo;
    public DdOrdenPickingFinderById(DdOrdenPickingQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdOrdenPicking findById(FindByIdDdOrdenPickingQuery query) {
        Objects.requireNonNull(query);
        DdOrdenPicking x=repo.findById(new DdOrdenPickingKey(query.getCodigoEmpresa(), query.getLoCodigo(), query.getSku()));
        if(x==null) throw new DdOrdenPickingNotFoundException(query);
        return x;

    }

}
