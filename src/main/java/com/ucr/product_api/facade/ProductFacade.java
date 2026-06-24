package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.dtos.ProductRequestDto;
import com.ucr.product_api.mappers.ProductMapper;
import com.ucr.product_api.services.IProductService;

@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductDtoList(productService.getAll());
    }

    @Override
    public ProductDto getById(Long id) {
        return productMapper.toProductDto(productService.getById(id));
    }

    @Override
    public ProductDto create(ProductDto productDto) { //Ejercicio@PostMapping
        com.ucr.product_api.entities.Product product = productMapper.toProductEntity(productDto);
        com.ucr.product_api.entities.Product saved = productService.create(product);
        return productMapper.toProductDto(saved);
    }

    @Override //Ejercicio@PostMapping D99 - Agregando el post al proyecto
    @Transactional
    public ProductDto addProduct(ProductRequestDto productDto) {
        var entity = productService.addProduct(productDto);
        return productMapper.toProductDto(entity);
    }

    //D99 - Implementar el método updateProduct en ProductFacade. 
    // Este método debe llamar al método updateProduct del servicio,
    @Override
    //@Transactional es para asegurar que la operación de actualización se realice dentro de una transacción, 
    // lo que garantiza la integridad de los datos.
    @Transactional 
    public ProductDto updateProduct(UUID resourceId, ProductRequestDto product) {
        var entity = productService.updateProduct(resourceId, product);
        return productMapper.toProductDto(entity);
    }

    //D107 - Implementar el método getByResourceId en ProductFacade. 
    // Este método debe llamar al método getByResourceId del servicio 
    // y luego mapear el resultado a un ProductDto utilizando el ProductMapper.
    @Override
    public ProductDto getByResourceId(UUID resourceId) {
        var entity = productService.getByResourceId(resourceId);
        return productMapper.toProductDto(entity);
    }

    @Override
    @Transactional
    public void removeProduct(UUID resourceId) {
        productService.removeProduct(resourceId);
    }
}
