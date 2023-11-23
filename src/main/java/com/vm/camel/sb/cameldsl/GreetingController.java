package com.vm.camel.sb.cameldsl;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    ProducerTemplate producerTemplate;
    @GetMapping("/api/greet/{name}")
    public String greet(@PathVariable String name) {
        // You can use Camel to process the request here, or delegate to Camel route
        // For simplicity, we'll just return the value from the Camel route directly
        producerTemplate.requestBody("direct:sample",name,String.class);
        return "Hello, " + name + "!";
    }
}
