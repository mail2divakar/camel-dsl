package com.vm.camel.sb.cameldsl.component;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;
public class CustomComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        System.out.println("Inside Custom Component");
        return new CustomEndpoint(uri, this);
    }
}
