package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DdBultosCreator  {

    private final DdBultosCommandRepository repo;

    public DdBultosCreator(DdBultosCommandRepository repo)  {

        this.repo = Objects.requireNonNull(repo);

    }

    public DdBultos create(CreateDdBultosCommand c)  {

        Objects.requireNonNull(c);

        DdBultos a = DdBultosMapper.from(c);

        try  {

            int r = repo.create(a);

            if (r != 1) throw new DdBultosUnexpectedRowsException(r);

            return a;

        }
        catch (DdBultosUnexpectedRowsException e)  {

            throw e;

        }
        catch (Exception e)  {

            throw new DdBultosPersistenceException(e);

        }

    }

}
