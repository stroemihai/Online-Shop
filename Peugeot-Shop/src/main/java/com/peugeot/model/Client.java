package com.peugeot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private List<Order> order;
}