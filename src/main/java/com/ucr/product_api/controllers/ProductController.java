package com.ucr.product_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.facade.IProductFacade;
import com.ucr.product_api.mappers.ProductMapper;
import com.ucr.product_api.models.ProductRequestModel;
import com.ucr.product_api.models.ProductResponseModel;

@RestController
@RequestMapping("/products") // Define el endpoint base para los productos
public class ProductController {

    //D60
    @Autowired // Inyecta la dependencia del ProductFacade
    private IProductFacade productFacade;

    @Autowired // Inyecta la dependencia del ProductMapper
    private ProductMapper productMapper;

    @GetMapping // Define el endpoint para obtener todos los productos
    public ResponseEntity<List<ProductResponseModel>> findAll() {
        return ResponseEntity.ok(productMapper.toProductResponseModelList(productFacade.getAll()));
    }

/*    @GetMapping(path = "/{id}") //D64 Obtener producto por ID numérico (db id)
    public ProductResponseModel findById(@PathVariable("id") Long id) {
        return productMapper.toProductResponseModel(productFacade.getById(id));
    }
*/
    // Define el endpoint para crear un nuevo producto
    @PostMapping
    public ProductDto save(@RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        return productFacade.addProduct(dto);
    }

    // Define el endpoint para actualizar un producto existente
    @PutMapping(path = "/{resourceId}")
    public ProductDto update(@PathVariable("resourceId") UUID resourceId,
            @RequestBody ProductRequestModel productRequestModel) {
        var dto = productMapper.toProductRequestDto(productRequestModel);
        return productFacade.updateProduct(resourceId, dto);
    }

    // Endpoint para obtener un producto por su resourceId (UUID)
    @GetMapping(path = "/{resourceId}")
    public ProductDto findById(@PathVariable("resourceId") UUID resourceId) {
        return productFacade.getByResourceId(resourceId);
    }

    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId") UUID resourceId) {
        productFacade.removeProduct(resourceId);
    }

}
