package tc2r.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tc2r.springframework.services.HelloWorldService;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/helloworld-config.xml",
        "classpath:/spring/config-english.xml"})
public class EnglishIntegrationTest {

  @Autowired
  HelloWorldService helloWorldService;

  @Test
  public void testHelloWorld(){
    String greeting = helloWorldService.getGreeting();

    assertEquals("~~~~~~Hello World~~~~", greeting);
  }
}
