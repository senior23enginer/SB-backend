package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdPedidoPickingFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id.DdPedidoPickingFinderById domainFinder;
    private DdPedidoPickingFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find_by_id.DdPedidoPickingFinderById.class);
        finder = new DdPedidoPickingFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdPedidoPicking expected = mock(DdPedidoPicking.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdPedidoPicking result = finder.execute(new FindByIdDdPedidoPickingQuery(1L));
        assertSame(expected, result);

    }

}
