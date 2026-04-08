package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPickingFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id.DdOrdenPickingFinderById domainFinder;
    private DdOrdenPickingFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find_by_id.DdOrdenPickingFinderById.class);
        finder = new DdOrdenPickingFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdOrdenPicking expected = mock(DdOrdenPicking.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdOrdenPicking result = finder.execute(new FindByIdDdOrdenPickingQuery(1L, 1L, "X"));
        assertSame(expected, result);

    }

}
