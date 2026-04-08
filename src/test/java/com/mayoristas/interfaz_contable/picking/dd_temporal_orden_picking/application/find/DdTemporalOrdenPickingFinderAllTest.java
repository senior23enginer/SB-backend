package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find.DdTemporalOrdenPickingFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdTemporalOrdenPickingFinderAllTest  {
    DdTemporalOrdenPickingFinder finder;
    DdTemporalOrdenPickingFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdTemporalOrdenPickingFinder.class);
        useCase=new DdTemporalOrdenPickingFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdTemporalOrdenPickingQuery(1,20)));

    }
}
