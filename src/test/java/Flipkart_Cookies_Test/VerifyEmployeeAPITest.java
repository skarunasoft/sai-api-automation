package Flipkart_Cookies_Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import io.restassured.response.Response;
import payload.EmployeePayloadJson;
import wrapper.RESTAPIMethod;

public class VerifyEmployeeAPITest extends RESTAPIMethod {

	Response response;
	String id;
	String firstName;
	String phone;

	@BeforeMethod
	public void preRequest() {
		baseEmployeeURL();
	}

	@Test
	public void verifyE2EEmployeeTest() throws InterruptedException {

		response = postRequest(EmployeePayloadJson.createEmployee("Rahul", "Dravid", "rahul@gmail.com", "7777799999"),
				Constant.EMPLOYEE_RESOURCE);
		Assert.assertEquals(response.statusCode(), 201);
		id = getJsonValue(response, "id");

		requestWait(10000);

		System.out.println("id:" + id);

		response = getRequest(Constant.EMPLOYEE_RESOURCE + "/" + id);
		firstName = getJsonValue(response, "first_name");
		Assert.assertEquals(firstName, "Rahul");

		System.out.println("response:" + response.asPrettyString());

		response = putRequest(EmployeePayloadJson.modifyEmp("Rahuls", "Dravid", "rahul@gmail.com", "7777799999"),
				Constant.EMPLOYEE_RESOURCE, id);
		firstName = getJsonValue(response, "first_name");
		Assert.assertEquals(firstName, "Rahuls");

		response = patchRequest(EmployeePayloadJson.partialModifyEmp("7654787999"), Constant.EMPLOYEE_RESOURCE, id);
		phone = getJsonValue(response, "phone");
		Assert.assertEquals(phone, "7654787999");

		response = deleteRequest(Constant.EMPLOYEE_RESOURCE, id);

		response = getRequest(Constant.EMPLOYEE_RESOURCE + "/" + id);
		Assert.assertEquals(response.statusCode(), 404);

		System.out.println("statusCode:" + response.statusCode());
		System.out.println("response:" + response.asPrettyString());

	}

}
