package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create.DdOrdenPedidosCreator;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.DdOrdenPedidosAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPedidosCreatorWithoutExistsTest  {
    private DdOrdenPedidosCreator creator;
    private DdOrdenPedidosQueryRepository queryRepository;
    private DdOrdenPedidosCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdOrdenPedidosCreator.class);
        queryRepository = mock(DdOrdenPedidosQueryRepository.class);
        useCase = new DdOrdenPedidosCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdOrdenPedidos.class));
        assertThrows(DdOrdenPedidosAlreadyExistsException.class, () -> useCase.execute(new DdOrdenPedidosCreateWithoutExistsCommand(1L, 1L, "X", "X", "X", "X", "X", "X", "X", "X", "X", 1L, 1L, "X", 1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
