package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ResourceReader;
import wrapper.RESTAPIMethod;

public class BasicAuth  extends RESTAPIMethod{
	
	
	@BeforeMethod
	public void preRequest() {
		
		baseURL("https://the-internet.herokuapp.com");
		
	}
	
	
	@Test
	public void basicAuth() {
		
		
		Response response =  given()
		 .auth()
		 .basic(ResourceReader.getPropertyValue("username"), ResourceReader.getPropertyValue("password"))
		 .when()
		 .get("/basic_auth");
		
		
		System.out.println(response.statusCode());
		System.out.println(response.asPrettyString());
			
		
		
	}
	
	
	

}
