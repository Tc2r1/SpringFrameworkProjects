package tc2r.springframework.services;


public class HelloWorldServiceEngImpl implements HelloWorldService {
	
	@Override
	public String getGreeting() {
		return "~~~~~~Hello World~~~~";
	}
	
}