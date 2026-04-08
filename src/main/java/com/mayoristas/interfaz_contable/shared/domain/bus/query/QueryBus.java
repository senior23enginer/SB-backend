package com.mayoristas.interfaz_contable.shared.domain.bus.query;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionError;
}
