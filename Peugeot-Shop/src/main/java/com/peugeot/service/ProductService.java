package com.peugeot.service;

import com.peugeot.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Integer id);
    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProductById(ProductDto productDto, Integer id);
    void deleteProductById(Integer id);
}
