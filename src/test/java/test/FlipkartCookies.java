package test;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import wrapper.RESTAPIMethod;

public class FlipkartCookies extends RESTAPIMethod{
	
	
	
	
	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL();
	}

	@Test
	public void employeeForm() {

		RestAssured.baseURI = "https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART";

		Response response = given()				
				.when()
				.get(); 

		System.out.println(response.headers());
		System.out.println("------------------------------------------");
		System.out.println(response.cookies());
		System.out.println(response.cookie("T"));
		System.out.println(response.getCookies());
		
		
		for (Map.Entry<String, String> entry : response.cookies().entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			
			System.out.println("key::"+key+" value::"+val);
			
			
		}
		


	}
	
	
	
	
	
	
	
	
	

}
