package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdTemporalOrdenPickingFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id.DdTemporalOrdenPickingFinderById domainFinder;
    private DdTemporalOrdenPickingFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find_by_id.DdTemporalOrdenPickingFinderById.class);
        finder = new DdTemporalOrdenPickingFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdTemporalOrdenPicking expected = mock(DdTemporalOrdenPicking.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdTemporalOrdenPicking result = finder.execute(new FindByIdDdTemporalOrdenPickingQuery(1L, 1L, "X"));
        assertSame(expected, result);

    }

}
