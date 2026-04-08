package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

public final class DdBultosMapper  {

    private DdBultosMapper()  {

    }

    public static DdBultos from(CreateDdBultosCommand command)  {

        return new DdBultos(command.getCodigoEtiqueta(), command.getIdRecvta(), command.getImpresora(), command.getFechaImpresion(), command.getUsuarioImpresion(), command.getIndUtilizado());

    }

}
