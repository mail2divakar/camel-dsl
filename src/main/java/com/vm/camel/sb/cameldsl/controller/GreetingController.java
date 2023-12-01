package com.vm.camel.sb.cameldsl.controller;

import com.vm.camel.sb.cameldsl.model.MySchema;
import com.vm.camel.sb.cameldsl.model.Order;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Order> save(@RequestBody Order order) {
        producerTemplate.requestBody("direct:order",order);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        return ResponseEntity.ok().body(orderList.get(0));
    }

    @PostMapping("/validate")
    public String validate(@RequestBody MySchema mySchema) {
        producerTemplate.requestBody("direct:startvalidator", "mock:valid", String.class);
        return "valid";
    }

    @GetMapping("/expression")
    public ResponseEntity<String> expressionValidator(@RequestHeader("myHeader") String myHeader) {
        Optional<String> optional = Optional.ofNullable(myHeader);
        if(optional.isPresent()) {
            producerTemplate.sendBodyAndHeader("direct:expressions", myHeader, "myHeader", "foo");
            return ResponseEntity.ok().body("Route triggered with value of " + myHeader);
        }
        return ResponseEntity.ok().body("Please add Header Values");//To change body of created methods use File | Settings | File Templates.
    }


    @GetMapping("/expression1")
    public ResponseEntity<String> expressionValidator(@RequestHeader("myHeader") String myHeader, @RequestHeader("continue") String continueHeader) {
        Optional<String> optional = Optional.ofNullable(myHeader);
        if(optional.isPresent()) {
            producerTemplate.sendBodyAndHeader("direct:example", myHeader, "continue", myHeader);
            return ResponseEntity.ok().body("Route triggered with value of " + myHeader);
        }
        return ResponseEntity.ok().body("Please add Header Values");//To change body of created methods use File | Settings | File Templates.
    }


    @PostMapping("/logger")
    public ResponseEntity<String> customLogger(@RequestBody String customeLogger) {
        Optional<String> optional = Optional.ofNullable(customeLogger);
        if(!optional.isPresent()) {
            producerTemplate.requestBody("direct:customlogger", customeLogger, String.class);
            return  ResponseEntity.ok().body("Route triggered with value of " + customeLogger);
        }
        return ResponseEntity.ok().body("Please add the body Values");//To change body of created methods use File | Settings | File Templates.
    }


    @GetMapping("/exception")
    public String handleException() {
        producerTemplate.requestBody("direct:errorHandler", "Exception", String.class);
        return "Exception handled";   //To change body of created methods use File | Settings | File Templates.
    }

    @GetMapping("/sqs")
    public String sqsExample() {
        producerTemplate.sendBodyAndHeader("direct:sendsqs", "Hello, SQS!", "CamelAws2SqsQueueUrl", "https://sqs.ap-south-1.amazonaws.com/014916155302/CamelQueue");
        return "SQS Message Send";   //To change body of created methods use File | Settings | File Templates.
    }
}
