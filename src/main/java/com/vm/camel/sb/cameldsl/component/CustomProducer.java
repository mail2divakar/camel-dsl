package com.vm.camel.sb.cameldsl.component;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;
import org.mule.weave.v2.runtime.DataWeaveResult;
import org.mule.weave.v2.runtime.DataWeaveScript;
import org.mule.weave.v2.runtime.DataWeaveScriptingEngine;
import org.mule.weave.v2.runtime.ScriptingBindings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class CustomProducer extends DefaultProducer {

    public CustomProducer(Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String request = (String) exchange.getIn().getBody();
        String jsonData = convertDwScriptToJson(request);
        exchange.getMessage().setBody(jsonData);

    }
    public String convertDwScriptToJson(String request) throws FileNotFoundException {
        DataWeaveScriptingEngine scriptingEngine = new DataWeaveScriptingEngine();

        File scriptFile = ResourceUtils.getFile("classpath:dw_scripts/sample.dwl");
        DataWeaveScript compile =  scriptingEngine.compile(scriptFile,  new String[]{"payload"});
        DataWeaveResult result = compile.write(new ScriptingBindings()
                //.addBinding("status", inputPayload, "application/java", new HashMap<>())
                .addBinding("payload", request, "application/json", new HashMap<>()));
        return result.getContentAsString();
    }
}
