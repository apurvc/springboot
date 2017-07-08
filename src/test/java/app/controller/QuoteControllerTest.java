package app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.apurv.Application;
import com.apurv.model.QuoteV1;
import com.apurv.model.QuoteV2;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class QuoteControllerTest {
	
	private RestTemplate restTemplate = new RestTemplate(); 
	
	private String RANDOM_URL ="http://localhost:8888/api/quote/random";
	private String BASE_URL ="http://localhost:8888/api/quote";
	
    @Test
    public void should_respond_with_random_quote() throws Exception {
    	HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.parseMediaType("application/vnd.example.app-v1+json"));
    	HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
    	ResponseEntity<QuoteV1> response = restTemplate.exchange(RANDOM_URL,HttpMethod.GET,requestEntity, QuoteV1.class);
    	assertNotNull(response);
    	assertNotNull(response.getBody().getValue().getQuote());
    }
      
    @Test
    public void test_quote_byId() throws Exception {
    	HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.parseMediaType("application/vnd.example.app-v1+json"));
    	HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
    	ResponseEntity<QuoteV1> response = restTemplate.exchange(BASE_URL+"/4",HttpMethod.GET,requestEntity, QuoteV1.class);
    	assertThat(response.getStatusCode(),is(HttpStatus.OK));
    	assertThat(response.getBody().getValue().getId().toString(),is("4"));
    }
    
    @Test
    public void should_respond_with_random_quote_with_type() throws Exception {
    	HttpHeaders requestHeaders = new HttpHeaders();
    	requestHeaders.setContentType(MediaType.parseMediaType("application/vnd.example.app-v2+json"));
    	HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
    	ResponseEntity<QuoteV2> response = restTemplate.exchange(RANDOM_URL,HttpMethod.GET,requestEntity, QuoteV2.class);
    	assertThat(response.getStatusCode(),is(HttpStatus.OK));
    	assertThat(response.getBody().getType(),is("success"));
    	//assertThat(response.getHeaders().containsValue("application/vnd.example.app-v2+json;charset=UTF-8"));
    }    
}
