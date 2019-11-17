package tc2r.springframework.services;


public class HelloWorldServiceGermanImpl implements HelloWorldService {
	
	@Override
	public String getGreeting() {
		return "~~~~~~Hallo Welt~~~~";
	}
	
}