package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdDetallePickingFinderTest  {

    private DdDetallePickingQueryRepository queryRepository;

    private DdDetallePickingFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdDetallePickingQueryRepository.class);

        finder = new DdDetallePickingFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
