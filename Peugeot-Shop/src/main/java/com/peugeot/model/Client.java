package com.peugeot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer id;

    @Column(name = "client_first_name", nullable = false)
    private String firstName;

    @Column(name = "client_last_name", nullable = false)
    private String lastName;

    @Column(name = "client_address", nullable = false)
    private String address;

    @Column(name = "client_phone", nullable = false)
    private String phone;

    @Column(name = "client_email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Order> order;
}