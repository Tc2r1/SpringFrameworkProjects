package tc2r.springframework.services;


public class HelloWorldServiceZuluImpl implements HelloWorldService {
	
	@Override
	public String getGreeting() {
		return "~~~~~~Hello Wêreld~~~~";
	}
	
}