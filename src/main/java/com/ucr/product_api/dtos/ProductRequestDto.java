package com.ucr.product_api.dtos;

import java.math.BigDecimal;

//Agregando el post al proyecto D84

//Agregando lombok para generar getters, setters, constructores, etc.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;

    //en ProductService se presentó un error con price por la diferencia entre BigDecimal y double,
    // por lo que se cambió el tipo de dato a BigDecimal 
    // para evitar problemas de precisión con los precios.
}