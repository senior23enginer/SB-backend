package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create;

import java.time.LocalDateTime;

public class CreateDdBultosCommand  {

    private final Long codigoEtiqueta;

    private final Long idRecvta;

    private final String impresora;

    private final LocalDateTime fechaImpresion;

    private final String usuarioImpresion;

    private final String indUtilizado;

    public CreateDdBultosCommand(Long codigoEtiqueta, Long idRecvta, String impresora, LocalDateTime fechaImpresion, String usuarioImpresion, String indUtilizado)  {

        this.codigoEtiqueta = codigoEtiqueta;

        this.idRecvta = idRecvta;

        this.impresora = impresora;

        this.fechaImpresion = fechaImpresion;

        this.usuarioImpresion = usuarioImpresion;

        this.indUtilizado = indUtilizado;

    }

    public Long getCodigoEtiqueta()  {

        return codigoEtiqueta;

    }

    public Long getIdRecvta()  {

        return idRecvta;

    }

    public String getImpresora()  {

        return impresora;

    }

    public LocalDateTime getFechaImpresion()  {

        return fechaImpresion;

    }

    public String getUsuarioImpresion()  {

        return usuarioImpresion;

    }

    public String getIndUtilizado()  {

        return indUtilizado;

    }

}
