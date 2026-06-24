package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.ProductDto;
import com.ucr.product_api.dtos.ProductRequestDto;
import com.ucr.product_api.entities.Product;
import com.ucr.product_api.models.ProductRequestModel;
import com.ucr.product_api.models.ProductResponseModel;

@Component
public class ProductMapper {

    //D48
    public ProductDto toProductDto(Product product) {
        if (product == null) {
            return null;
        }
        /* Si tienen un error en estos métodos, revisar la clase y verificar que los nombres tengan la primera letra en mayúscula
    o verificar que se llame correctamente */
        return new ProductDto(product.getResourceId(), product.getName(), product.getDescription(), product.getPrice());
    }

    //D49
    public List<ProductDto> toProductDtoList(List<Product> products) {
        if (products == null) {
            return null;
        }

        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductResponseModel toProductResponseModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        return new ProductResponseModel(productDto.resourceId(), productDto.name(), productDto.description(), productDto.price());
    }

    public List<ProductResponseModel> toProductResponseModelList(List<ProductDto> productDtos) {
        if (productDtos == null) {
            return null;
        }

        return productDtos.stream()
                .map(this::toProductResponseModel)
                .collect(Collectors.toList());
    }

    public Product toProductEntity(ProductDto dto) { //Ejercicio@PostMapping
        if (dto == null) {
            return null;
        }

        UUID resourceId = dto.resourceId() == null ? UUID.randomUUID() : dto.resourceId();

        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .resourceId(resourceId)
                .build();
    }
    //D92 Agregar método toProductRequestDto que recibe un ProductRequestModel y devuelve un ProductRequestDto
    public ProductRequestDto toProductRequestDto(ProductRequestModel product) {
        if (product == null) {
            return null;
        }
        ProductRequestDto productDto = new ProductRequestDto();
        productDto.setName(product.name());
        productDto.setDescription(product.description());
        productDto.setPrice(product.price());
        return productDto;
    }
}
