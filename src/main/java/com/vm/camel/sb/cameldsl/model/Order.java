package com.vm.camel.sb.cameldsl.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "quantity")
public class Order {
    private String orderId;
    private String product;
    private int quantity;
    

	

    // Getters, setters, constructors...
}
