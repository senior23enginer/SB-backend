package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdBultosFinderTest  {

    private DdBultosQueryRepository queryRepository;

    private DdBultosFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdBultosQueryRepository.class);

        finder = new DdBultosFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
