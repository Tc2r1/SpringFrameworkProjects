package tc2r.springframework.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default", "english"})
public class HelloWorldServiceEngImpl implements HelloWorldService {


	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
	
}