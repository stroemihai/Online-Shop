package com.peugeot.model;

import com.peugeot.enums.FuelType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
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


    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
