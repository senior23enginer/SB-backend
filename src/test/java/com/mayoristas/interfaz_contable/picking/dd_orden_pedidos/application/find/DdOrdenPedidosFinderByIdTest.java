package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPedidosFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id.DdOrdenPedidosFinderById domainFinder;
    private DdOrdenPedidosFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find_by_id.DdOrdenPedidosFinderById.class);
        finder = new DdOrdenPedidosFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdOrdenPedidos expected = mock(DdOrdenPedidos.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdOrdenPedidos result = finder.execute(new FindByIdDdOrdenPedidosQuery(1L, 1L));
        assertSame(expected, result);

    }

}
