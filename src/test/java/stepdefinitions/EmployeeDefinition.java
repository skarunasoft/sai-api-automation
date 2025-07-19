package stepdefinitions;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payload.EmployeePayloadJson;
import wrapper.RESTAPIMethod;

public class EmployeeDefinition extends RESTAPIMethod {

	Response response;

	@Given("the Application base API URL is {string}")
	public void the_application_base_api_url_is(String url) {

		baseEmployeeURL(url);

	}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String empPathParam) {

		response = getRequest(empPathParam);

	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int statusCode) {
		
		Hooks.threadScenario.get().log("API Status Code: "+ String.valueOf(response.statusCode()));  
		Assert.assertEquals(response.statusCode(), statusCode);
	}

	@Then("the response should contain a list of employees")
	public void the_response_should_contain_a_list_of_employees() {
		
		
		Hooks.threadScenario.get().log("Employee API Response: "+ response.asPrettyString());
		System.out.println(response.asPrettyString());

	}
	
	@When("I send a POST request to {string} with employee payload")
	public void i_send_a_post_request_to_with_employee_payload(String pathParam) {
		
		
		
		String emp = EmployeePayloadJson.createEmployee("f1", "l1", "898989898", "test@gmail.com");
		Hooks.threadScenario.get().log(emp);
		response = postRequest("application/json",
				emp,
				pathParam);
		
		
		
	}
	
	

	@Then("each employee should have the id, first_name and phone")
	public void each_employee_should_have_the_id_first_name_and_phone() {
	}

}
