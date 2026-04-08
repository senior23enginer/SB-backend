package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.DdOrdenPedidosPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdOrdenPedidos}.
 */
@Service
public class DdOrdenPedidosFinder {

    private final DdOrdenPedidosQueryRepository queryRepository;

    public DdOrdenPedidosFinder(DdOrdenPedidosQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdOrdenPedidosQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdOrdenPedidos> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdOrdenPedidosPersistenceException(ex);
        }
    }
}
