package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create.DdBultosMapper;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DdBultosUpdater  {

    private final DdBultosCommandRepository repo;

    public DdBultosUpdater(DdBultosCommandRepository repo)  {

        this.repo = Objects.requireNonNull(repo);

    }

    public int execute(UpdateDdBultosCommand c)  {

        Objects.requireNonNull(c);

        DdBultos a = DdBultosMapper.from(c);

        try  {

            int r = repo.update(a);

            if (r != 1) throw new DdBultosUnexpectedRowsException(r);

            return r;

        }
        catch (DdBultosUnexpectedRowsException e)  {

            throw e;

        }
        catch (Exception e)  {

            throw new DdBultosPersistenceException(e);

        }

    }

}
