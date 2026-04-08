package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create.DdConfiguracionReposicionCreator;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.DdConfiguracionReposicionAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdConfiguracionReposicionCreatorWithoutExistsTest  {
    private DdConfiguracionReposicionCreator creator;
    private DdConfiguracionReposicionQueryRepository queryRepository;
    private DdConfiguracionReposicionCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdConfiguracionReposicionCreator.class);
        queryRepository = mock(DdConfiguracionReposicionQueryRepository.class);
        useCase = new DdConfiguracionReposicionCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdConfiguracionReposicion.class));
        assertThrows(DdConfiguracionReposicionAlreadyExistsException.class, () -> useCase.execute(new DdConfiguracionReposicionCreateWithoutExistsCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
