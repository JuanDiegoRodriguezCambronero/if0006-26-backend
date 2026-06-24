package com.ucr.product_api.models;

//D90 Agregar import para las validaciones de los campos del ProductRequestModel
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//D90 Agregar import para BigDecimal del precio
import java.math.BigDecimal; 

//record es para crear una clase inmutable, 
// es decir, una clase cuyos objetos no pueden ser modificados después de su creación. 
// Esto es útil para garantizar la integridad de los datos 
// y evitar errores relacionados con la mutabilidad. 
// En este caso, ProductRequestModel es un record que representa la estructura de los datos 
// que se esperan en una solicitud para crear o actualizar un producto.
public record ProductRequestModel(
        @NotBlank(message = "El nombre es requerido") String name,
        String description,
        @NotNull(message = "El precio es requerido") @Positive(message = "El precio debe ser mayor a 0") BigDecimal price) {
}
