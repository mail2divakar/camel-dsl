package com.vm.camel.sb.cameldsl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String product;
    private int quantity;


    // Getters, setters, constructors...
}