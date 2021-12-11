package com.ba;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Test-Application", version = "v1"))
@SecurityScheme(name = "Basic-Authentication", scheme = "basic", type = SecuritySchemeType.HTTP,
		in = SecuritySchemeIn.HEADER)
//@SecurityScheme(name = "JWT-Authentication", scheme = "bearer", type = SecuritySchemeType.HTTP)
public class BasicAuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthDemoApplication.class, args);
	}

}
