package com.mayoristas.interfaz_contable.shared.domain.bus.query;

public interface QueryHandler<Q extends Query, R extends Response> {
    R handle(Q query);
}
