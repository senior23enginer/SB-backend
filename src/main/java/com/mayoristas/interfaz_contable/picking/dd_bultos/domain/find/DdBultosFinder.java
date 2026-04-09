package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdBultos}.
 */
@Service
public class DdBultosFinder {

    private final DdBultosQueryRepository queryRepository;

    public DdBultosFinder(DdBultosQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdBultosQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdBultos> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdBultosPersistenceException(ex);
        }
    }

    public List<DdBultos> findByFilters(
            Long idRecvta,
            String impresora,
            String usuarioImpresion,
            String indUtilizado,
            int limit,
            int offset
    ) {
        try {
            return queryRepository.findByFilters(idRecvta, impresora, usuarioImpresion, indUtilizado, limit, offset);
        } catch (Exception ex) {
            throw new DdBultosPersistenceException(ex);
        }
    }
}
