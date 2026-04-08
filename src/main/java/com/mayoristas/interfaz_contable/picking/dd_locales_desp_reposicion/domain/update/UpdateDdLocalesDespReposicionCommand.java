package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create.CreateDdLocalesDespReposicionCommand;
import java.time.LocalDateTime;

public class UpdateDdLocalesDespReposicionCommand extends CreateDdLocalesDespReposicionCommand  {
    public UpdateDdLocalesDespReposicionCommand(Long codigoEmpresaDt, Long idReposicion, Long codigoEmpresaDesp, Long loCodigoDesp, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresaDt, idReposicion, codigoEmpresaDesp, loCodigoDesp, fechaCreacion, creadoPor);

    }

}
