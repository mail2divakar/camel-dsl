package com.vm.camel.sb.cameldsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@ImportResource("classpath:routes/camel-routes.yaml")
public class CamelDslApplication {

	public static void main(String[] args) {
		//CamelContext ctx = new DefaultCamelContext();
		//ctx.
		SpringApplication.run(CamelDslApplication.class, args);
		//System.out.println(new File("C:\\Workspaces\\eclipse\\camel-dsl\\src\\main\\java\\com\\vm\\camel\\sb\\cameldsl").listFiles()[0].getName());
	}

}
