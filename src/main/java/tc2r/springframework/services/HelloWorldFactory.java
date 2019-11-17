package tc2r.springframework.services;

public class HelloWorldFactory {
	
	public HelloWorldService createHelloWorldService(String language) {
		HelloWorldService service = null;
		
		switch (language) {
		case "en":
			service = new HelloWorldServiceEngImpl();
			break;
		case "es":
			service = new HelloWorldServiceEspImpl();
			break;
		case "fr":
			service = new HelloWorldServiceFrenchImpl();
			break;
		case "de":
			service = new HelloWorldServiceGermanImpl();
			break;
		case "zu":
			service = new HelloWorldServiceZuluImpl();
			break;
		case "af":
			service = new HelloWorldServiceAfrikaansImpl();
			break;

		default:
			service = new HelloWorldServiceEngImpl();
			break;
		}
		
		return service;
	}

}
