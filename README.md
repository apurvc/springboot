# springboot-versioned-api
Sample REST API using Spring Boot. This app is just an attempt to check the different response based on custom media type. It utilizes quote API found at http://gturnquist-quoters.cfapps.io/api to provide the random quotes.
  
Project can be run using command mvn spring-boot:run

The API's  can be tested using any rest client by hitting http://localhost:8989/api/quote/random or with custom content-type headers 

	curl -v -X GET -H "Content-Type: application/vnd.example.app-v1+json" http://localhost:8989/api/quote/random
	curl -v -X GET -H "Content-Type: application/vnd.example.app-v2+json" http://localhost:8989/api/quote/random
	curl -v -X GET -H "Content-Type: application/vnd.example.app-v1+json" http://localhost:8989/api/quote/4

This app is just an attempt to check the different response based on custom media type. 

update:
1. added Dockerfile : to build the docker image use 
		
		docker build -t restapi:v1 . 
		docker run -p 8989:8989 restapi:v1
		
2. Updated the spring boot version to 2.0.5.RELEASE 


References: 
		
		http://www.baeldung.com/rest-versioning


