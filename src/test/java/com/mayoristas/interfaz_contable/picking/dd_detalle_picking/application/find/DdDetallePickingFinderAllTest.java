package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find.DdDetallePickingFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetallePickingFinderAllTest  {
    DdDetallePickingFinder finder;
    DdDetallePickingFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdDetallePickingFinder.class);
        useCase=new DdDetallePickingFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdDetallePickingQuery(1,20)));

    }
}
