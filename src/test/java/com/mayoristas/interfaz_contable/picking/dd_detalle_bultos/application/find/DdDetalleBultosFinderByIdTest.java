package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetalleBultosFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id.DdDetalleBultosFinderById domainFinder;
    private DdDetalleBultosFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find_by_id.DdDetalleBultosFinderById.class);
        finder = new DdDetalleBultosFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdDetalleBultos expected = mock(DdDetalleBultos.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdDetalleBultos result = finder.execute(new FindByIdDdDetalleBultosQuery(1L, 1L));
        assertSame(expected, result);

    }

}
