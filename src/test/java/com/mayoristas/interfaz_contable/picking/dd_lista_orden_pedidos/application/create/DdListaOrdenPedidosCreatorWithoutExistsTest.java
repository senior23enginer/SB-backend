package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create.DdListaOrdenPedidosCreator;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.DdListaOrdenPedidosAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdListaOrdenPedidosCreatorWithoutExistsTest  {
    private DdListaOrdenPedidosCreator creator;
    private DdListaOrdenPedidosQueryRepository queryRepository;
    private DdListaOrdenPedidosCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdListaOrdenPedidosCreator.class);
        queryRepository = mock(DdListaOrdenPedidosQueryRepository.class);
        useCase = new DdListaOrdenPedidosCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdListaOrdenPedidos.class));
        assertThrows(DdListaOrdenPedidosAlreadyExistsException.class, () -> useCase.execute(new DdListaOrdenPedidosCreateWithoutExistsCommand(1L, 1L, "X", "X", 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
