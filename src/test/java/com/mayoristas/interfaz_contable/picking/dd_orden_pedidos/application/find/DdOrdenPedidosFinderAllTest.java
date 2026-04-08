package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find.DdOrdenPedidosFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPedidosFinderAllTest  {
    DdOrdenPedidosFinder finder;
    DdOrdenPedidosFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdOrdenPedidosFinder.class);
        useCase=new DdOrdenPedidosFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdOrdenPedidosQuery(1,20)));

    }
}
