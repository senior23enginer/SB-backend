package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosKey;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddBultosFinderByIdDomain")
public class DdBultosFinderById  {

    private final DdBultosQueryRepository repo;

    public DdBultosFinderById(DdBultosQueryRepository repo)  {

        this.repo = Objects.requireNonNull(repo);

    }

    public DdBultos findById(FindByIdDdBultosQuery query)  {

        Objects.requireNonNull(query);

        DdBultos x = repo.findById(new DdBultosKey(query.getCodigoEtiqueta()));

        if (x == null) throw new DdBultosNotFoundException(query);

        return x;

    }

}
