package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestCase02_Post_RestAssured {
	@Test
	void RegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParms = new JSONObject();
	}
}
