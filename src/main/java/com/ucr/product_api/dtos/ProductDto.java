package com.ucr.product_api.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
    UUID resourceId, /*D81 - Se agregó luego de realizar la modificación en la base de datos */
    String name,
    String description,
    BigDecimal price) {
}