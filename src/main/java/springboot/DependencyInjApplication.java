package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import tc2r.springframework.controllers.GreetingController;

@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml")
public class DependencyInjApplication {

	public static void main(String[] args) {
		ApplicationContext ctxApplicationContext = SpringApplication.run(DependencyInjApplication.class, args);
		
		GreetingController controller = (GreetingController) ctxApplicationContext.getBean("greetingController");
		
		controller.sayHello();
	}
}
