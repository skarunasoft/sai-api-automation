package wrapper;

import static io.restassured.RestAssured.given;

import java.util.Map;

import context.AppData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RESTAPIMethod extends AppData{
	
	
	
	
	public void baseEmployeeURL() {
		RestAssured.baseURI = "http://localhost:3000/";
	}
	
	public void baseEmployeeURL(String baseURL) {
		RestAssured.baseURI = baseURL;
	}
	
	
	public void baseURL(String baseURL) {
		RestAssured.baseURI = baseURL;
	}
	
	
	
	public Response getRequest(String pathParam) {
		Response response = given()
				.when()
				.get(pathParam);
		return response;
	}
	
	public Response getRequest(Map<String, String> queryParam, String pathParam) {
		Response response = given()
				.queryParams(queryParam)
				.when()
				.get(pathParam);
		return response;
	}
	
		
	
	public Response postRequest(String bodyContent, String pathParam) {
		Response response = given()
				.contentType(ContentType.JSON)
				.body(bodyContent)
				.post(pathParam);
		return response;
	}
	

	public Response postRequest(String contentType, String bodyContent, String pathParam) {
		Response response = given()
				.contentType(contentType)
				.body(bodyContent)
				.post(pathParam);
		return response;
	}
	
	
	
	public Response putRequest(String bodyContent, String pathParam, String id) {
		Response response = given()
				.contentType(ContentType.JSON)
				.body(bodyContent)
				.put(pathParam+"/"+id);
		return response;
	}
	
	public Response patchRequest(String bodyContent, String pathParam, String id) {
		Response response = given()
				.contentType(ContentType.JSON)
				.body(bodyContent)
				.patch(pathParam+"/"+id);
		return response;
	}
	
	public Response deleteRequest(String pathParam, String id) {
		Response response = given()
				.when()
				.delete(pathParam+"/"+id);
		return response;
	}
	
	
	public String getJsonValue(Response response, String key) {
		String value="";
		try {
			JsonPath jsonData = response.jsonPath();
			value = jsonData.get(key).toString();
		} catch (Exception e) {
			System.out.println("Response value is null" + response.asPrettyString());
		}
		return value;
		
	}
	
	
	
	public void requestWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//authorization methods
	
	public Response apiKeyAuth(String pathParam,
				String apiKey,
				String apiKeyValue,
				String cityName
			
			) {
			Response response = given()
					.queryParam(apiKey, apiKeyValue)
					.queryParam("q", cityName)
					.when()
					.get(pathParam);
			return response;
	}
	
	
	
	
	
	

}
