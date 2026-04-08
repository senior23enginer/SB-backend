package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPedidosCreatorTest  {
    DdOrdenPedidosCommandRepository repo;
    DdOrdenPedidosCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdOrdenPedidosCommandRepository.class);
        creator=new DdOrdenPedidosCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdOrdenPedidos.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdOrdenPedidosCommand(1L, 1L, "X", "X", "X", "X", "X", "X", "X", "X", "X", 1L, 1L, "X", 1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
