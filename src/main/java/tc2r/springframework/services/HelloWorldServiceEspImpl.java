package tc2r.springframework.services;

public class HelloWorldServiceEspImpl implements HelloWorldService {
	
	@Override
	public String getGreeting() {
		return "Hola Mundo!";
	}

}
