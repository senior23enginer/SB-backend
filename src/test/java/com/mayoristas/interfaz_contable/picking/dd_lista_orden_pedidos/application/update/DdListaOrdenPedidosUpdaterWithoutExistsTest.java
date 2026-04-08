package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.update.DdListaOrdenPedidosUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdListaOrdenPedidosUpdaterWithoutExistsTest  {
    DdListaOrdenPedidosUpdater d;
    DdListaOrdenPedidosUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdListaOrdenPedidosUpdater.class);
        u=new DdListaOrdenPedidosUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdListaOrdenPedidosByIdCommand(1L, 1L, "X", "X", 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
