package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.update.UpdateDdLocalesDespReposicionCommand;
import java.time.LocalDateTime;

public class UpdateDdLocalesDespReposicionByIdCommand extends UpdateDdLocalesDespReposicionCommand  {
    public UpdateDdLocalesDespReposicionByIdCommand(Long codigoEmpresaDt, Long idReposicion, Long codigoEmpresaDesp, Long loCodigoDesp, LocalDateTime fechaCreacion, String creadoPor) {
        super(codigoEmpresaDt, idReposicion, codigoEmpresaDesp, loCodigoDesp, fechaCreacion, creadoPor);

    }

}
