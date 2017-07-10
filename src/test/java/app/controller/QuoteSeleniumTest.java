package app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.apurv.Application;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
//@SpringApplicationConfiguration(classes = Application.class)
public class QuoteSeleniumTest {
	
	//@Autowired
	private WebDriver webDriver;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\selenium-chrome-driver-2.53.1.jar");
		webDriver = new ChromeDriver();
	}
	
	@Test
	public void testQuote(){
		webDriver.get("http://localhost:8989/random");
	}

}
