package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@ComponentScan(basePackages="com")
public class MallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallAppApplication.class, args);
	}
	
//	@Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
////        return (container -> {
////            container.setSessionTimeout(1000);  // session timeout value
////        });
////		WebServerFactoryCustomizer container = new WebServerFactoryCustomizer();
//		return c -> c.
//    }
	
}
