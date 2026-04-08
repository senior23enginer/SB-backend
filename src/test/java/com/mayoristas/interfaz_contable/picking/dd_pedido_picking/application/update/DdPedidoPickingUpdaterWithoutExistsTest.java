package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.update.DdPedidoPickingUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdPedidoPickingUpdaterWithoutExistsTest  {
    DdPedidoPickingUpdater d;
    DdPedidoPickingUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdPedidoPickingUpdater.class);
        u=new DdPedidoPickingUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdPedidoPickingByIdCommand(1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", 1L, 1L)));

    }

}
