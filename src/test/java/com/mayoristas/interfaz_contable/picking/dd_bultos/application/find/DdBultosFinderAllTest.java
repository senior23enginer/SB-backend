package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find.DdBultosFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdBultosFinderAllTest  {
    DdBultosFinder finder;
    DdBultosFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdBultosFinder.class);
        useCase=new DdBultosFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdBultosQuery(1,20)));

    }
}
