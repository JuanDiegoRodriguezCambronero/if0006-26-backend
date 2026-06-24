package com.ucr.product_api.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucr.product_api.entities.Product;

//@Repository // Indicates that this interface is a Spring Data repository.
public interface ProductRepository extends JpaRepository<Product, Long> {
    default List<Product> getAll() {
        return findAll();
    }

    public Product getById(Long id);

    //Agregando el post al proyecto D83
    default Product addProduct(Product product) { 
        return save(product);
    }
    
    //Se agrega el método para actualizar un producto D94
    default Product updateProduct(Product product) {
        return save(product);
    }
    // findByResourceId DP:95 - Agregar el método para buscar un producto por su resourceId

    Optional<Product> findByResourceId(UUID resourceId); //D96 - Agregar los importes necesarios para UUID y Optional
}