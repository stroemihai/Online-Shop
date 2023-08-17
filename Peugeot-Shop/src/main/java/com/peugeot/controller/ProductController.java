package com.peugeot.controller;

import com.peugeot.dto.ProductDto;
import com.peugeot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("message", "Product created successfully.")
                .body(savedProduct);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Integer productId){
        ProductDto productById = productService.getProductById(productId);

        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Integer productId,
                                                    @RequestBody ProductDto productDto){
        ProductDto updatedProduct = productService.updateProductById(productDto, productId);

        return ResponseEntity.status(HttpStatus.OK)
                .header("message", "Product updated successfully.")
                .body(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("productId") Integer productId){
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().header("message", "Product deleted successfully.").build();
    }
}
