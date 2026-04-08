package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find.DdListaOrdenPedidosFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdListaOrdenPedidosFinderAllTest  {
    DdListaOrdenPedidosFinder finder;
    DdListaOrdenPedidosFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdListaOrdenPedidosFinder.class);
        useCase=new DdListaOrdenPedidosFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdListaOrdenPedidosQuery(1,20)));

    }
}
