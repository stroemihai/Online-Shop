package com.peugeot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.peugeot.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_brand", nullable = false)
    private String brand;

    @Column(name = "product_model", nullable = false)
    private String model;

    @Column(name = "product_fuel_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "product_hp", nullable = false)
    private Integer hp;

    @Column(name = "product_engine", nullable = false)
    private String engine;

    @Column(name = "product_year", nullable = false)
    private Integer year;

    @Column(name = "product_price", nullable = false)
    private Double price;


    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Order> orders;

}
