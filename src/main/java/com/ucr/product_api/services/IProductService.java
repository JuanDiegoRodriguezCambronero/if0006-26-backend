package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.ProductRequestDto;
import com.ucr.product_api.entities.Product;
//Agregarlo para el ejercicio@PostMapping. 
// El método addProduct recibe un ProductRequestDto como parámetro,
//que es un DTO (Data Transfer Object) que contiene los datos necesarios para crear un nuevo producto.
//Este DTO se utiliza para transferir datos entre el cliente y el servidor de manera más eficiente y segura, 
//evitando exponer directamente la entidad Product a través de la API.

public interface IProductService {

    List<Product> getAll();

    //public Product getById(Long id);
    public Product create(Product product);

    Product addProduct(ProductRequestDto productDto); //Ejercicio@PostMapping - D86

    //D96 - Agregar el método updateProduct que recibe un UUID y un ProductRequestDto como parámetros.
    //Agregar  el import necesario para UUID y ProductRequestDto.
    Product updateProduct(UUID resourceId, ProductRequestDto productDto);

    //D104 - Obtener producto por ID resource
    Product getByResourceId(UUID resourceId);

    public Product getById(Long id);

    void removeProduct(UUID resourceId);

}
