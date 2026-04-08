package com.mayoristas.interfaz_contable.picking.dd_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create.DdBultosCreator;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions.DdBultosAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdBultosCreatorWithoutExistsTest  {
    private DdBultosCreator creator;
    private DdBultosQueryRepository queryRepository;
    private DdBultosCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdBultosCreator.class);
        queryRepository = mock(DdBultosQueryRepository.class);
        useCase = new DdBultosCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdBultos.class));
        assertThrows(DdBultosAlreadyExistsException.class, () -> useCase.execute(new DdBultosCreateWithoutExistsCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", "X")));

    }

}
