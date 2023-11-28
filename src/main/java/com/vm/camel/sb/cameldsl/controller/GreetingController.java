package com.vm.camel.sb.cameldsl.controller;

import com.vm.camel.sb.cameldsl.model.MySchema;
import com.vm.camel.sb.cameldsl.model.Order;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class GreetingController {
    @Autowired
    ProducerTemplate producerTemplate;
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        producerTemplate.requestBody("direct:sample",name,String.class);
        return "Hello, " + name + "!";
    }

    @PostMapping("/save")
    public List<Order> save(@RequestBody Order order) {
        producerTemplate.requestBody("direct:order",order);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        return orderList;
    }

    @PostMapping("/validate")
    public String validate(@RequestBody MySchema mySchema) {
        producerTemplate.requestBody("direct:startvalidator", "mock:valid", String.class);
        return "valid";
    }

    @GetMapping("/expression")
    public String expressionValidator(@RequestHeader("myHeader") String myHeader) {
        producerTemplate.sendBodyAndHeader("direct:expressions", myHeader, "myHeader", "foo");
        return "Route triggered with value of "+ myHeader;
    }


    @GetMapping("/expression1")
    public String expressionValidator1(@RequestHeader("continue") String myHeader) {
        producerTemplate.sendBodyAndHeader("direct:example", myHeader, "continue", myHeader);
        return "Header value "+ myHeader;
    }


    @PostMapping("/logger")
    public String customLogger(@RequestBody String customeLogger) {
        producerTemplate.requestBody("direct:customlogger", customeLogger, String.class);
        return customeLogger;
    }



}
