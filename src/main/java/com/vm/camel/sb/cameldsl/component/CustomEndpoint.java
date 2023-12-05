package com.vm.camel.sb.cameldsl.component;

import org.apache.camel.*;
import org.apache.camel.support.DefaultEndpoint;

public class CustomEndpoint extends DefaultEndpoint {
    public CustomEndpoint() {
    }

    public CustomEndpoint(String endpointUri, Component component) {
        super(endpointUri, component);
    }

    @Override
    public Producer createProducer() throws Exception {
        return new CustomProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
       throw new UnsupportedOperationException();
    }

    public boolean isSingleton() {
        return true;
    }
}
