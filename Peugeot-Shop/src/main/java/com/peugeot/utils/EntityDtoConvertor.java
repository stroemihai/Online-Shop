package com.peugeot.utils;

import com.peugeot.dto.ClientDto;
import com.peugeot.dto.OrderDto;
import com.peugeot.dto.ProductDto;
import com.peugeot.model.Client;
import com.peugeot.model.Order;
import com.peugeot.model.Product;
import org.modelmapper.ModelMapper;

public class EntityDtoConvertor {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Client toEntity(ClientDto clientDto){
        return modelMapper.map(clientDto, Client.class);
    }

    public static ClientDto toDto(Client client){
        return modelMapper.map(client, ClientDto.class);
    }

    //Order
    public static Order toEntity(OrderDto orderDto){
        return modelMapper.map(orderDto, Order.class);
    }

    public static OrderDto toDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    // Product
    public static Product toEntity(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }

    public static ProductDto toDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }

}
