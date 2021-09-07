package com.sghazi.ebay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SGhaziEbayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SGhaziEbayApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/item/**").or(PathSelectors.ant("/imageURL/**")))
				.apis(RequestHandlerSelectors.basePackage("com.sghazi"))
				.build()
				.apiInfo(apiDetails());
	}

	public ApiInfo apiDetails() {
		return new ApiInfo(
				"SGhazi Ebay Home Assignment",
				"API for Ebay",
				"1.0",
				"For Interview Purposes",
				new springfox.documentation.service.Contact("Samira Ghazi", "", ""),
				"API License",
				"",
				Collections.emptyList());
	}
}
