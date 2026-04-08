package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdBultosFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id.DdBultosFinderById domainFinder;
    private DdBultosFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find_by_id.DdBultosFinderById.class);
        finder = new DdBultosFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdBultos expected = mock(DdBultos.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdBultos result = finder.execute(new FindByIdDdBultosQuery(1L));
        assertSame(expected, result);

    }

}
