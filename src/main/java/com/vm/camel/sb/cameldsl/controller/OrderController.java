package com.vm.camel.sb.cameldsl.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.camel.sb.cameldsl.model.Order;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Order order) {
    	System.out.println("Received payload"+order);
        producerTemplate.sendBody("direct:processOrder", order);
        return "Order processing initiated";
    }
}