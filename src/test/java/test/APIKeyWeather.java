package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import wrapper.RESTAPIMethod;

public class APIKeyWeather extends RESTAPIMethod{
	
	
	
	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL("https://api.openweathermap.org/data/2.5/");
	}
	
	
	
	
	@Test
	public void apiKeyAuth() {
		
		
	
		//Response response = getRequest("api.openweathermap.org/data/2.5/weather?q=London");
		
		Response response = apiKeyAuth("weather", "appid", "0cd0b421af1bdbbc7ae37f2879f63295", "Hyderabad");
		
		
		
		System.out.println(response.asPrettyString());
		
		
	}
	
	
	
	
	

}
