package app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apurv.Application;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class QuoteSeleniumTest {
	
	//@Autowired
	private WebDriver webDriver;
	
	@Before
	public void setup(){
		webDriver = new ChromeDriver();
	}
	
	@Test
	public void testQuote(){
		webDriver.get("http://localhost:8989/random");
	}

}
