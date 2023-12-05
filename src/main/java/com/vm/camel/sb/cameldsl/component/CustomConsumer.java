package com.vm.camel.sb.cameldsl.component;

import org.apache.camel.Endpoint;
import org.apache.camel.Processor;
import org.apache.camel.support.DefaultConsumer;

public class CustomConsumer extends DefaultConsumer {
    public CustomConsumer(Endpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void doStart() throws Exception {
        System.out.println("customconsumer started");
    }

    @Override
    protected void doStop() throws Exception {
       System.out.println("CustomConsumer Stopped");
    }
}
