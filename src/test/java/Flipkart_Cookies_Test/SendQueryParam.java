package Flipkart_Cookies_Test;

import static io.restassured.RestAssured.given;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import wrapper.RESTAPIMethod;

public class SendQueryParam extends RESTAPIMethod {

	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL();
	}

	@Test
	public void searchEmployee() {

		// http://localhost:3000/employees?first_name=Sachin&last_name=Tendulkar

		Response response = given().queryParam("first_name", "Sachin").queryParam("last_name", "Tendulkar").when()
				.get("employees");

		System.out.println(response.asPrettyString());

		Response response2 = given().queryParams(empFilterByName()).when().get("employees");

		System.out.println(response2.asPrettyString());

	}

}
