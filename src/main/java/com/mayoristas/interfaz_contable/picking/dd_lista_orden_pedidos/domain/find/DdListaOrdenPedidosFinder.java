package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.DdListaOrdenPedidosPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdListaOrdenPedidos}.
 */
@Service
public class DdListaOrdenPedidosFinder {

    private final DdListaOrdenPedidosQueryRepository queryRepository;

    public DdListaOrdenPedidosFinder(DdListaOrdenPedidosQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdListaOrdenPedidosQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdListaOrdenPedidos> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdListaOrdenPedidosPersistenceException(ex);
        }
    }
}
