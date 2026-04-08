package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.update.DdOrdenPedidosUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPedidosUpdaterWithoutExistsTest  {
    DdOrdenPedidosUpdater d;
    DdOrdenPedidosUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdOrdenPedidosUpdater.class);
        u=new DdOrdenPedidosUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdOrdenPedidosByIdCommand(1L, 1L, "X", "X", "X", "X", "X", "X", "X", "X", "X", 1L, 1L, "X", 1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
