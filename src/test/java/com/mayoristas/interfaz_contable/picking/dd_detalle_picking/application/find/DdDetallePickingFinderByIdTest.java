package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetallePickingFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id.DdDetallePickingFinderById domainFinder;
    private DdDetallePickingFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find_by_id.DdDetallePickingFinderById.class);
        finder = new DdDetallePickingFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdDetallePicking expected = mock(DdDetallePicking.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdDetallePicking result = finder.execute(new FindByIdDdDetallePickingQuery(1L, 1L));
        assertSame(expected, result);

    }

}
