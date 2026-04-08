package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdListaOrdenPedidosCreatorTest  {
    DdListaOrdenPedidosCommandRepository repo;
    DdListaOrdenPedidosCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdListaOrdenPedidosCommandRepository.class);
        creator=new DdListaOrdenPedidosCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdListaOrdenPedidos.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdListaOrdenPedidosCommand(1L, 1L, "X", "X", 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
