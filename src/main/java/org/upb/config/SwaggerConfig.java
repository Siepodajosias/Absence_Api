package org.upb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket getBean() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("org.upb"))
				.paths(regex("/api.*")).build()
				.apiInfo(getInfo());
	}
	
   public ApiInfo getInfo() {
	   return new ApiInfoBuilder().title("API REST DE GESTION DES ABSENCES D'UPB").description(""
	   		+ ""
	   		+ "API est une abréviation et signifie Application Programming Interface : c’est un moyen de communication entre deux logiciels, que ce soit entre différents composants d’une application ou entre deux applications différentes."
	   		+ "  "
	   		+ "\r\n"
	   		+ "\r\n"
	   		
	   		+ "        Une API facilite l’interaction entre deux applications différentes afin qu’elles puissent communiquer entre elles : elle sert d’intermédiaire. Le client va demander à l’API une information, celle-ci va aller chercher cette information dans la base de données puis la renvoyer au client dans un second temps.\r\n"
	   		+ "\r\n"
	   		+ "Les API peuvent communiquer :\r\n"
	   		+ "•	D’un logiciel à un autre ;\r\n"
	   		+ "•	D’un client à un serveur ;\r\n"
	   		+ "•	Ou d’un logiciel à des développeurs.\r\n"
	   		+ "")
			   .license("Licence:UPB")
			   .build();
   }
}
