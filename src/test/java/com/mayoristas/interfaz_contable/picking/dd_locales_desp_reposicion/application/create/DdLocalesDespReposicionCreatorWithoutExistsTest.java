package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create.DdLocalesDespReposicionCreator;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.DdLocalesDespReposicionAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdLocalesDespReposicionCreatorWithoutExistsTest  {
    private DdLocalesDespReposicionCreator creator;
    private DdLocalesDespReposicionQueryRepository queryRepository;
    private DdLocalesDespReposicionCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdLocalesDespReposicionCreator.class);
        queryRepository = mock(DdLocalesDespReposicionQueryRepository.class);
        useCase = new DdLocalesDespReposicionCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdLocalesDespReposicion.class));
        assertThrows(DdLocalesDespReposicionAlreadyExistsException.class, () -> useCase.execute(new DdLocalesDespReposicionCreateWithoutExistsCommand(1L, 1L, 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
