package restAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase02_Post_RestAssured {
	@Test
	void RegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParms = new JSONObject();
		requestParms.put("FirstName", "Vijaykumar");
		requestParms.put("LastName", "Kulkarni");
		requestParms.put("UserName", "Vijaykumar");
		requestParms.put("Password", "vijay123");
		requestParms.put("Email", "vijayk9596@gmail.com");
		
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(requestParms.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/register");
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body: " +responseBody);
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 201);
		
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
