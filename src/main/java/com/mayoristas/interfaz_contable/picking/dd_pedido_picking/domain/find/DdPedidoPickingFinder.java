package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.DdPedidoPickingPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdPedidoPicking}.
 */
@Service
public class DdPedidoPickingFinder {

    private final DdPedidoPickingQueryRepository queryRepository;

    public DdPedidoPickingFinder(DdPedidoPickingQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdPedidoPickingQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdPedidoPicking> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdPedidoPickingPersistenceException(ex);
        }
    }
}
