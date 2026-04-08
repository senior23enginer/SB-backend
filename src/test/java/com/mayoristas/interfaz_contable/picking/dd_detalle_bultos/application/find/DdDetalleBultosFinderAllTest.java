package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find.DdDetalleBultosFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetalleBultosFinderAllTest  {
    DdDetalleBultosFinder finder;
    DdDetalleBultosFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdDetalleBultosFinder.class);
        useCase=new DdDetalleBultosFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdDetalleBultosQuery(1,20)));

    }
}
