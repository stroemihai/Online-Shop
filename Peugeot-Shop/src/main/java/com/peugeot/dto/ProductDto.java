package com.peugeot.dto;

import com.peugeot.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String brand;
    private String model;
    private FuelType fuelType;
    private Integer hp;
    private String engine;
    private Integer year;
    private Double price;

    public ProductDto(String brand, String model, FuelType fuelType, Integer hp, String engine, Integer year, Double price) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.hp = hp;
        this.engine = engine;
        this.year = year;
        this.price = price;
    }
}