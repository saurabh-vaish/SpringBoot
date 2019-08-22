package com.app.config;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 	Swagger :-  Swagger is a 3rd party automated tool for testing ReSt application.  It is developed by spring fox .
 * 				 It provide a user friendly ui called Swagger-Ui  to test rest application . 
 * 				
 * 		Dependency ---  springfox-swagger2  , springfox-swagger-ui
 * 
 * 			-->  To use swagger in our application we need to configure it first .
 * 
 * 		@EnableSwagger2 --->  To enable swagger
 * 
 * 		Docket   --> It is swagger ui container 
 * 
 * 		DocumentationType --> Tells Swagger version,  Swagger_2 is latest version . 
 * 
 * 		basePackage()  ---> package for all the rest controllers , static method of RequestHandlerSelectors
 * 
 * 		paths -->  get restcontroller by matching regex provided . static method of PathSelectors
 * 
 * 
 * **/



@Configuration
@EnableSwagger2						// to enable swagger
public class SwaggerConfig {

	@Bean
	public Docket configSwagger()
	{
		return new Docket(DocumentationType.SWAGGER_2)				// create docket with swagger version
				.select()											// to select apis for swagger
				.apis(basePackage("com.app.controller.rest"))		//  using static import , to specify package for rest controller 
				.paths(regex("/rest.*"))						// identify rest controller by regex
				.build()									/// build docket
				
				// from  here optional 
				.apiInfo(apiInfo())				// to provide extra details 
				;
	}
	
	
	// it is optional only to provide additional details
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder() 			// using builder factory ApiInfoBuilder that will make easy to construct object and return ApiInfo
				.title("My Project Swagger")
				.description("this is swagger implementation for rest")
				.contact(new Contact("saurabh vaish","www.theincrediblesrv.epizy.com", "saurabh.vaish1993@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0")
				.build();
	}
	
}
