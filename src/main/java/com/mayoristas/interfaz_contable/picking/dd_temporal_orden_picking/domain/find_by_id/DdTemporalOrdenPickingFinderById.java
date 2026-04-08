package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingKey;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.DdTemporalOrdenPickingNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddTemporalOrdenPickingFinderByIdDomain") public class DdTemporalOrdenPickingFinderById  {
    private final DdTemporalOrdenPickingQueryRepository repo;
    public DdTemporalOrdenPickingFinderById(DdTemporalOrdenPickingQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdTemporalOrdenPicking findById(FindByIdDdTemporalOrdenPickingQuery query) {
        Objects.requireNonNull(query);
        DdTemporalOrdenPicking x=repo.findById(new DdTemporalOrdenPickingKey(query.getCodigoEmpresa(), query.getLoCodigo(), query.getSku()));
        if(x==null) throw new DdTemporalOrdenPickingNotFoundException(query);
        return x;

    }

}
