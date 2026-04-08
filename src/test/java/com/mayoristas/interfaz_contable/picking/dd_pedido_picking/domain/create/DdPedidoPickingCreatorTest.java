package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdPedidoPickingCreatorTest  {
    DdPedidoPickingCommandRepository repo;
    DdPedidoPickingCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdPedidoPickingCommandRepository.class);
        creator=new DdPedidoPickingCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdPedidoPicking.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdPedidoPickingCommand(1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", 1L, 1L)));

    }

}
