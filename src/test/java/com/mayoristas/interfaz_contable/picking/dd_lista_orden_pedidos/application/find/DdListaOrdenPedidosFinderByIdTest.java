package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdListaOrdenPedidosFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id.DdListaOrdenPedidosFinderById domainFinder;
    private DdListaOrdenPedidosFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find_by_id.DdListaOrdenPedidosFinderById.class);
        finder = new DdListaOrdenPedidosFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdListaOrdenPedidos expected = mock(DdListaOrdenPedidos.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdListaOrdenPedidos result = finder.execute(new FindByIdDdListaOrdenPedidosQuery(1L, 1L, "X", "X"));
        assertSame(expected, result);

    }

}
