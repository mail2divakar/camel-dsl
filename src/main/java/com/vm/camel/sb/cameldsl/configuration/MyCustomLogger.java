package com.vm.camel.sb.cameldsl.configuration;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyCustomLogger implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(MyCustomLogger.class);


    @Override
    public void process(Exchange exchange) throws Exception {
        LOG.info("Custom Logger example: {}", exchange.getIn().getBody());
    }
}
