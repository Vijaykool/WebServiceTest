package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase01_RestAssured {
	@Test
	void getWeatherDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Bangalore");
		
		String responseBody = response.getBody().asString();
		System.out.println("Body is: "+responseBody);
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		
		System.out.println("Status line: "+statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
}
