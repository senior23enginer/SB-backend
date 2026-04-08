package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create.CreateDdLocalesDespReposicionCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion}
 * validando previamente que no exista por llave primaria.
 */
public class DdLocalesDespReposicionCreateWithoutExistsCommand extends CreateDdLocalesDespReposicionCommand {

    public DdLocalesDespReposicionCreateWithoutExistsCommand(Long codigoEmpresaDt, Long idReposicion, Long codigoEmpresaDesp, Long loCodigoDesp, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresaDt, idReposicion, codigoEmpresaDesp, loCodigoDesp, fechaCreacion, creadoPor);
    }
}
