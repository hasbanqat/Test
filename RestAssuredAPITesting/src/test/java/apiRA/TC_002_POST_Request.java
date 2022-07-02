package apiRA;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_002_POST_Request {
	
	@Test
	void postRequest() {
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification httprequest=RestAssured.given();
	JSONObject requestPayload=new JSONObject();
	requestPayload.put("name", "morpheus");
	requestPayload.put("job", "leader");
	
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestPayload.toJSONString());
	
	Response response=httprequest.request(Method.POST);
	
	String responseBody=response.getBody().asString();
	System.out.println("Response body is " +responseBody);
	
	int responseCode=response.getStatusCode();
	Assert.assertEquals(responseCode, 201);
	
	
	/*UString successCode=response.jsonPath().get("SuccessCode");
	System.out.println("Status Line is:" +successCode);
	Assert.assertEquals(successCode, "null");*/
	
		
		
	}

}
