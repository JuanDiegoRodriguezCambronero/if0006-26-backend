package com.ucr.product_api.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.annotations.Type;
//import org.hibernate.type.UUIDBinaryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*  Lombok genera automáticamente métodos como get y set al compilar por eso no
    se escriben manualmente, si no se tuvieran las anotaciones de Lombok, se
    deberían escribir manualmente los métodos get y set para cada atributo
*/
// Spring entiende que esta clase debe mapearse a una tabla.
// el nombre de la tabla en la base de datos.
@Entity
@Table(name = "product") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false, length = 255)
    private String name;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "Price", precision = 38, scale = 2, nullable = false)
    private BigDecimal price;
    
    @Column(name = "resource_id", nullable = false, unique = true, columnDefinition = "BINARY(16)")
    //@JdbcTypeCode(SqlTypes.BINARY)
    private UUID resourceId;
}