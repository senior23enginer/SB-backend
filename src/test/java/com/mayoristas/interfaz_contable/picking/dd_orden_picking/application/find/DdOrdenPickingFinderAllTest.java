package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find.DdOrdenPickingFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPickingFinderAllTest  {
    DdOrdenPickingFinder finder;
    DdOrdenPickingFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdOrdenPickingFinder.class);
        useCase=new DdOrdenPickingFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdOrdenPickingQuery(1,20)));

    }
}
