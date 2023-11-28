package com.vm.camel.sb.cameldsl.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomException implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomException.class);
    @Override
    public void process(Exchange exchange)  {
        int result = 1/0;
        LOGGER.info("Result is {}", result);
    }
}
