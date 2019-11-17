package tc2r.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import tc2r.springframework.services.HelloWorldFactory;
import tc2r.springframework.services.HelloWorldService;
import tc2r.springframework.services.HelloWorldServiceEngImpl;
import tc2r.springframework.services.HelloWorldServiceEspImpl;

@Configuration// tells spring that this is a configuration class.
public class HelloConfig {
	
	@Bean
	public HelloWorldFactory HelloWorldFactory() {
		return new HelloWorldFactory();
	}
	
	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("english")
	public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory) {
		return factory.createHelloWorldService("en");
	}

	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("spanish")
	public HelloWorldService helloWorldServiceSpanish(HelloWorldFactory factory) {
		return factory.createHelloWorldService("es");
	}
	
	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("afrikaans")
	public HelloWorldService helloWorldServiceAfikaans(HelloWorldFactory factory) {
		return factory.createHelloWorldService("af");
	}
	
	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("french")
	public HelloWorldService helloWorldServiceFrench(HelloWorldFactory factory) {
		return factory.createHelloWorldService("fr");
	}
	
	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("german")
	public HelloWorldService helloWorldServiceGerman(HelloWorldFactory factory) {
		return factory.createHelloWorldService("de");
	}
	
	@Bean // Tells spring that this is a Bean Configuration.
	@Profile("zulu")
	public HelloWorldService helloWorldServiceZulu(HelloWorldFactory factory) {
		return factory.createHelloWorldService("zu");
	}
	
}
