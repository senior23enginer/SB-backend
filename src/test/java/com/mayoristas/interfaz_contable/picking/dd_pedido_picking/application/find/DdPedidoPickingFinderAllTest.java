package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find.DdPedidoPickingFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdPedidoPickingFinderAllTest  {
    DdPedidoPickingFinder finder;
    DdPedidoPickingFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdPedidoPickingFinder.class);
        useCase=new DdPedidoPickingFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdPedidoPickingQuery(1,20)));

    }
}
