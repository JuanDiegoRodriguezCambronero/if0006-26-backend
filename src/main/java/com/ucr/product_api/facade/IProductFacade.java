package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.ProductDto;

//D88 Agregar import para ProductRequestDto del addProduct
import com.ucr.product_api.dtos.ProductRequestDto; 


public interface IProductFacade {

	List<ProductDto> getAll();

	public ProductDto getById(Long id);

	public ProductDto create(ProductDto productDto);

	//D88 Agregar método addProduct que recibe un ProductRequestDto y devuelve un ProductDto
	ProductDto addProduct(ProductRequestDto productDto); 

	//D98 - Agregar el método updateProduct que recibe un UUID y un ProductRequestDto como parámetros, y devuelve un ProductDto.
	ProductDto updateProduct(UUID resourceId, ProductRequestDto productDto);

	//D106 - Agregar el método getByResourceId que recibe un UUID como parámetro y devuelve un ProductDto. 
	// Este método debe buscar un producto por su resourceId y devolver su información en forma de ProductDto.
	ProductDto getByResourceId(UUID resourceId);

	void removeProduct(UUID resourceId);



}

