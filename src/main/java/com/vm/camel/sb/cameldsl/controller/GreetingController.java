package com.vm.camel.sb.cameldsl.controller;

import com.vm.camel.sb.cameldsl.model.MySchema;
import com.vm.camel.sb.cameldsl.model.Order;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class GreetingController {
    @Autowired
    ProducerTemplate producerTemplate;


    @GetMapping("/list")  //To change body of created methods use File | Settings | File Templates.
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        return list;  //To change body of created methods use File | Settings | File Templates.
    }
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
        Optional<String> optional = Optional.ofNullable(myHeader);
        if(optional.isPresent()) {
            producerTemplate.sendBodyAndHeader("direct:expressions", myHeader, "myHeader", "foo");
            return "Route triggered with value of " + myHeader;
        }
        return "Please add Header Values";
    }


    @GetMapping("/expression1")
    public String expressionValidator1(@RequestHeader("continue") String myHeader) {
        Optional<String> optional = Optional.ofNullable(myHeader);
        if(optional.isPresent()) {
            producerTemplate.sendBodyAndHeader("direct:example", myHeader, "continue", myHeader);
            return "Header value " + myHeader;
        }
        return "Please add Header Values";   //To change body of created methods use File | Settings | File Templates.
    }


    @PostMapping("/logger")
    public String customLogger(@RequestBody String customeLogger) {
        Optional<String> optional = Optional.ofNullable(customeLogger);
        if(!optional.isPresent()) {
            producerTemplate.requestBody("direct:customlogger", customeLogger, String.class);
            return customeLogger;
        }
        return "Please provide the custom logger body";   //To change body of created methods use File | Settings | File Templates.
    }


    @GetMapping("/exception")
    public String exception() {
        producerTemplate.requestBody("direct:errorHandling", "Exception catch Success", String.class);
        return "Exception";   //To change body of created methods use File | Settings | File Templates.
    }
}
