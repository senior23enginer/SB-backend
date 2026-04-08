package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create.DdPedidoPickingCreator;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.DdPedidoPickingAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdPedidoPickingCreatorWithoutExistsTest  {
    private DdPedidoPickingCreator creator;
    private DdPedidoPickingQueryRepository queryRepository;
    private DdPedidoPickingCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdPedidoPickingCreator.class);
        queryRepository = mock(DdPedidoPickingQueryRepository.class);
        useCase = new DdPedidoPickingCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdPedidoPicking.class));
        assertThrows(DdPedidoPickingAlreadyExistsException.class, () -> useCase.execute(new DdPedidoPickingCreateWithoutExistsCommand(1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", 1L, 1L)));

    }

}
