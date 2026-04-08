package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingKey;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.DdDetallePickingNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddDetallePickingFinderByIdDomain") public class DdDetallePickingFinderById  {
    private final DdDetallePickingQueryRepository repo;
    public DdDetallePickingFinderById(DdDetallePickingQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdDetallePicking findById(FindByIdDdDetallePickingQuery query) {
        Objects.requireNonNull(query);
        DdDetallePicking x=repo.findById(new DdDetallePickingKey(query.getIdRecvta(), query.getInventoryItemId()));
        if(x==null) throw new DdDetallePickingNotFoundException(query);
        return x;

    }

}
