package com.peugeot.dto;

import com.peugeot.model.Client;
import com.peugeot.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private LocalDate date_order;
    private Integer order_no;
    private String order_name;
    private Integer quantity;
//    private List<ProductDto> productsDto;
//    private ClientDto clientDto;

    public OrderDto(LocalDate date_order, Integer order_no, String order_name, Integer quantity) {
        this.date_order = date_order;
        this.order_no = order_no;
        this.order_name = order_name;
        this.quantity = quantity;
//        this.clientDto = clientDto;
    }

//    public List<ProductDto> getProductDto(){
//        if (productsDto == null){
//            productsDto = new ArrayList<>();
//        }
//
//        return productsDto;
//    }
}