package tc2r.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tc2r.springframework.controllers.GreetingController;

@SpringBootApplication
public class DependencyInjApplication {

	public static void main(String[] args) {
		ApplicationContext ctxApplicationContext = SpringApplication.run(DependencyInjApplication.class, args);
		
		GreetingController controller = (GreetingController) ctxApplicationContext.getBean("greetingController");
		
		controller.sayHello();
	}

}
