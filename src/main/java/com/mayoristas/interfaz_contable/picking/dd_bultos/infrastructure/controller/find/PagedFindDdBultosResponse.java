package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.controller.find;

import java.util.List;

public record PagedFindDdBultosResponse(
        List<FindDdBultosItemResponse> content,
        int page,
        int limit,
        int count
) {
}
