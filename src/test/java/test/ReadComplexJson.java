package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import io.restassured.response.Response;
import payload.EmployeePayloadJson;
import wrapper.RESTAPIMethod;

public class ReadComplexJson extends RESTAPIMethod {

	@Test
	public void readJsonAndTest() {

		baseEmployeeURL();
		Response response = getRequest("employee");

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertTrue(responseJson.length() > 0);

	}

	@Test
	public void filterEmpDataTest() {

		baseEmployeeURL();


		Response response = getRequest(EmployeePayloadJson.filterByEmpId("b896"),
										Constant.EMPLOYEE_RESOURCE);

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertTrue(responseJson.length() > 0);
		
		
		
		
		

	}

	@Test
	public void addNewEmpTest() {

		baseEmployeeURL();

		Response response = postRequest(
				EmployeePayloadJson.createEmployee("Ravi", "K", "89889898", "ravi@gmail.com"),
				Constant.EMPLOYEE_RESOURCE);

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 201);
		Assert.assertTrue(responseJson.length() > 0);

	}
	
	
	@Test
	public void modifyExistingEmpTest() {

		baseEmployeeURL();
		String id = "2fd0";
		

		Response response = putRequest(
				EmployeePayloadJson.modifyEmp(
						"Ravikumar", "RK", "89dd889898", "ravi@gmail.com"),
				Constant.EMPLOYEE_RESOURCE, id);

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertTrue(responseJson.length() > 0);

	}
	
	@Test
	public void changePhoneNumberExistingEmpTest() {

		baseEmployeeURL();
		String id = "2fd0";
		

		Response response = patchRequest(
				EmployeePayloadJson.partialModifyEmp(
						"79899393939"),
				Constant.EMPLOYEE_RESOURCE, id);

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertTrue(responseJson.length() > 0);

	}
	
	
	@Test
	public void deleteEmpTest() {

		baseEmployeeURL();
		String id = "2fd0";

		Response response = deleteRequest(		
				Constant.EMPLOYEE_RESOURCE, id);

		int statusCode = response.statusCode();
		String responseJson = response.asPrettyString();
		System.out.println("statusCode:" + statusCode);
		System.out.println("responseJson:" + responseJson);
		
		Assert.assertEquals(statusCode, 200);

	}
	
	
	
	
	
	
	
	

}
