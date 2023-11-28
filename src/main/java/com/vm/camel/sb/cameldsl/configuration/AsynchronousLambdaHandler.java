//package com.vm.camel.sb.cameldsl.configuration;
//
//import com.amazonaws.serverless.exceptions.ContainerInitializationException;
//import com.amazonaws.serverless.proxy.internal.testutils.Timer;
//import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
//import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
//import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
//import com.vm.camel.sb.cameldsl.CamelDslApplication;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class AsynchronousLambdaHandler  implements RequestStreamHandler {
//    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
//
//    static {
//        try {
//            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(CamelDslApplication.class);
//        }catch (ContainerInitializationException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Could not initialize Spring Boot application", e);
//        }
//    }
//
//    public AsynchronousLambdaHandler() {
//        // we enable the timer for debugging. This SHOULD NOT be enabled in production.
//        Timer.enable();
//    }
//
//    @Override
//    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
//        handler.proxyStream(inputStream,outputStream,context);
//    }
//}
