package com.vm.camel.sb.cameldsl.controller;

import com.vm.camel.sb.cameldsl.model.MySchema;
import com.vm.camel.sb.cameldsl.model.Order;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    ProducerTemplate producerTemplate;
    @GetMapping("/api/greet/{name}")
    public String greet(@PathVariable String name) {
        producerTemplate.requestBody("direct:sample",name,String.class);
        return "Hello, " + name + "!";
    }

    @PostMapping("/api/save")
    public List<Order> save(@RequestBody Order order) {
        producerTemplate.requestBody("direct:order",order);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        return orderList;
    }

    @PostMapping("api/validate")
    public String validate(@RequestBody MySchema mySchema) {
        producerTemplate.requestBody("direct:startvalidator", "mock:valid", String.class);
        return "valid";
    }

    @GetMapping("api/emp/{id}")
    public String expressionValidator(@PathVariable(value="id", required = true) String id) {
        producerTemplate.requestBody("direct:expressionvalidator", id, String.class);
        return id;
    }

}
