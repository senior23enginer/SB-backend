package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create.CreateDdBultosCommand;
import java.time.LocalDateTime;

public class UpdateDdBultosCommand extends CreateDdBultosCommand  {

    public UpdateDdBultosCommand(Long codigoEtiqueta, Long idRecvta, String impresora, LocalDateTime fechaImpresion, String usuarioImpresion, String indUtilizado)  {

        super(codigoEtiqueta, idRecvta, impresora, fechaImpresion, usuarioImpresion, indUtilizado);

    }

}
