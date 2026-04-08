package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create.DdDetalleBultosCreator;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.DdDetalleBultosAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetalleBultosCreatorWithoutExistsTest  {
    private DdDetalleBultosCreator creator;
    private DdDetalleBultosQueryRepository queryRepository;
    private DdDetalleBultosCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdDetalleBultosCreator.class);
        queryRepository = mock(DdDetalleBultosQueryRepository.class);
        useCase = new DdDetalleBultosCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdDetalleBultos.class));
        assertThrows(DdDetalleBultosAlreadyExistsException.class, () -> useCase.execute(new DdDetalleBultosCreateWithoutExistsCommand(1L, 1L, 1L)));

    }

}
