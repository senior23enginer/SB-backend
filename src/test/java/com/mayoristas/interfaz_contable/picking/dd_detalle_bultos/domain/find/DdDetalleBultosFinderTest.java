package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdDetalleBultosFinderTest  {

    private DdDetalleBultosQueryRepository queryRepository;

    private DdDetalleBultosFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdDetalleBultosQueryRepository.class);

        finder = new DdDetalleBultosFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
