package test;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import wrapper.RESTAPIMethod;

public class SendFormParam extends RESTAPIMethod{
	
	
	
	
	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL();
	}

	@Test
	public void employeeForm() {

		RestAssured.baseURI = "http://127.0.0.1:5000/";

		Response response = given()				
				.contentType("multipart/form-data")
				.multiPart("name", "Sachin")
				.multiPart("email", "Sachin@gmail.com")
				.multiPart("message", "god of cricketer")
				.multiPart("file", new File("D:\\SKARUNASOFT\\API\\API-Testing-Sai\\env.json"))	
				//remember: in addition add third parameter "multipart" if sending multiple file object for same upload field
				//.multiPart("file", new File("D:\\SKARUNASOFT\\API\\API-Testing-Sai\\env.json"), "multipart")	
				.when()
				.post("submit"); 

		System.out.println(response.asPrettyString());


	}
	
	
	
	
	
	
	
	
	

}
