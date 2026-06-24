package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.product_api.dtos.ProductRequestDto;
import com.ucr.product_api.entities.Product;
import com.ucr.product_api.repositories.ProductRepository; //Agregarlo para el ejercicio@PostMapping. D87

@Service // Marks this class as a Spring service component.
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product create(Product product) { //Ejercicio@PostMapping
        if (product.getResourceId() == null) {
            product.setResourceId(UUID.randomUUID());
        }
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(ProductRequestDto productDto) {
        var product = Product
                .builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .resourceId(UUID.randomUUID())
                .build();
        return productRepository.addProduct(product);
    }

    //D97 - Implementar el método updateProduct en ProductService. 
    // Este método debe buscar un producto por su resourceId, 
    // actualizar sus campos con los valores del ProductRequestDto y 
    // luego guardar los cambios en la base de datos utilizando el método updateProduct del repositorio.
    @Override
    public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return productRepository.updateProduct(product);
    }

    //D105
    @Override
    public Product getByResourceId(UUID resourceId) {
        return productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Product getById(Long id) {
        throw new UnsupportedOperationException("Use getByResourceId(UUID) instead");
    }

    @Override
    public void removeProduct(UUID resourceId) {
        var product = productRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(product);
    }

}
