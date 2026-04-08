package com.mayoristas.interfaz_contable.shared.domain.bus.query;

public final class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
    }
}
