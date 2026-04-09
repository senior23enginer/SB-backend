package com.mayoristas.interfaz_contable.picking.dd_bultos.application.find;

public class FindDdBultosByFiltersQuery {
    private final Long idRecvta;
    private final String impresora;
    private final String usuarioImpresion;
    private final String indUtilizado;
    private final int page;
    private final int limit;

    public FindDdBultosByFiltersQuery(
            Long idRecvta,
            String impresora,
            String usuarioImpresion,
            String indUtilizado,
            int page,
            int limit
    ) {
        this.idRecvta = idRecvta;
        this.impresora = impresora;
        this.usuarioImpresion = usuarioImpresion;
        this.indUtilizado = indUtilizado;
        this.page = page;
        this.limit = limit;
    }

    public Long getIdRecvta() {
        return idRecvta;
    }

    public String getImpresora() {
        return impresora;
    }

    public String getUsuarioImpresion() {
        return usuarioImpresion;
    }

    public String getIndUtilizado() {
        return indUtilizado;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }
}
