package com.vm.camel.sb.cameldsl.configuration;

import com.vm.camel.sb.cameldsl.component.CustomComponent;
import org.apache.camel.CamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean
    public CamelContext camelContext() {
        return new org.apache.camel.spring.SpringCamelContext();
    }

    @Bean
    public CustomComponent customComponent(){
        return new CustomComponent();
    }

}
