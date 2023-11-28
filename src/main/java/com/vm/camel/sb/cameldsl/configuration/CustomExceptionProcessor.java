package com.vm.camel.sb.cameldsl.configuration;

import com.vm.camel.sb.cameldsl.exception.CamelException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionProcessor.class);
    @Override
    public void process(Exchange exchange) throws CamelException {
        LOGGER.info("Custom Exception thrown");
        exchange.getIn().setBody("Custom Exception thrown");
        throw new CamelException("Camel Custom Exception thrown");
    }
}
