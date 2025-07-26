package Flipkart_Cookies_Test;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import utils.Helper;
import wrapper.RESTAPIMethod;

public class HttpLog extends RESTAPIMethod{
	
	
	
	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL();
	}

	
	
	//@Test
	public void viewLog() {
	
	Response response = given()
			.log().all()
			.queryParam("first_name", "Sachin")
			.queryParam("last_name", "Tendulkar")
			.when()
			.get("employees");
			response.then().log().all();

	//System.out.println(response.asPrettyString());

	
	}
	
	
	
	
	@Test(testName = "filterLog")
	public void filterLog() throws FileNotFoundException {
		
		String logPath = "./log/filterLog"+Helper.getCurrentDate()+".txt";
		
		PrintStream ps = new PrintStream(new File(logPath));
		
		
	Response response = given()
			.filter(RequestLoggingFilter.logRequestTo(ps))
			.filter(ResponseLoggingFilter.logResponseTo(ps))
			.queryParam("first_name", "Sachin")
			.queryParam("last_name", "Tendulkar")
			.when()
			.get("employees");

	//System.out.println(response.asPrettyString());

	
	}
	
	
	
	
	
	
	
	
	
	

}
