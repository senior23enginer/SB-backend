package com.mayoristas.interfaz_contable.picking.dd_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.update.UpdateDdBultosCommand;

import java.time.LocalDateTime;

public class UpdateDdBultosByIdCommand extends UpdateDdBultosCommand  {

    public UpdateDdBultosByIdCommand(Long codigoEtiqueta, Long idRecvta, String impresora, LocalDateTime fechaImpresion, String usuarioImpresion, String indUtilizado)  {

        super(codigoEtiqueta, idRecvta, impresora, fechaImpresion, usuarioImpresion, indUtilizado);

    }

}
