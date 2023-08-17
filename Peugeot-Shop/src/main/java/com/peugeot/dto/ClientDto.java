package com.peugeot.dto;

import com.peugeot.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
//    private List<Order> orders;


    public ClientDto(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}