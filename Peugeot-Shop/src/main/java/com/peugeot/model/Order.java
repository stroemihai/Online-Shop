package com.peugeot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_created_date")
    private LocalDate date_order;

    @Column(name = "order_no")
    private String order_no;

    @Column(name = "order_name")
    private String order_name;

    @Column(name = "order_quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}