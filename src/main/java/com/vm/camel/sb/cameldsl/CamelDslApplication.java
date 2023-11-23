package com.vm.camel.sb.cameldsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = "classpath:myschema.json")
public class CamelDslApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelDslApplication.class, args);
	}

}
