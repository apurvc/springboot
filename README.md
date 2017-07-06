# springboot-versioned-api
Sample REST API implementation using Spring Boot. This app is just an attempt to check the different response based on custom media type. It utilizes quote API found at http://gturnquist-quoters.cfapps.io/api to provide the random quotes.
  
Project can be run using command mvn spring-boot:run

The API versioning can be tested using any rest client by hitting http://localhost:8989/api/quote/random 
with custom accept headers 

Accept: "application/vnd.example.app-v1+json" or Accept: "application/vnd.example.app-v2+json"

This app is just an attempt to check the different response based on custom media type. 

References: 
		
		http://www.baeldung.com/rest-versioning

		https://github.com/spring-projects/spring-boot/issues/3116
 
