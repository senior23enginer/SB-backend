package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdTemporalOrdenPickingFinderTest  {

    private DdTemporalOrdenPickingQueryRepository queryRepository;

    private DdTemporalOrdenPickingFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdTemporalOrdenPickingQueryRepository.class);

        finder = new DdTemporalOrdenPickingFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
