package com.peugeot.service.impl;

import com.peugeot.dto.ProductDto;
import com.peugeot.exception.ProductNotFoundException;
import com.peugeot.model.Product;
import com.peugeot.repository.ProductRepository;
import com.peugeot.service.ProductService;
import com.peugeot.utils.EntityDtoConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(EntityDtoConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        return EntityDtoConvertor.toDto(product);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = EntityDtoConvertor.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return EntityDtoConvertor.toDto(savedProduct);
    }

    @Override
    public ProductDto updateProductById(ProductDto productDto, Integer id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        product.setBrand(productDto.getBrand());
        product.setModel(productDto.getModel());
        product.setFuelType(productDto.getFuelType());
        product.setHp(productDto.getHp());
        product.setEngine(productDto.getEngine());
        product.setYear(productDto.getYear());
        product.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(product);
        return EntityDtoConvertor.toDto(updatedProduct);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        productRepository.deleteById(id);
    }
}
