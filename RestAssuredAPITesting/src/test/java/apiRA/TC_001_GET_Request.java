package apiRA;

import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request {
	
	@Test
	void getUsersDetails()
	{
		//Specify Base URL
		
		RestAssured.baseURI="https://reqres.in/api/users";
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		//Response Object
		Response response=httprequest.request(Method.GET,"?page=2");
		//Print Response in the console
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is:" +responsebody);
		
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is:" +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//Status Line validation
		
		String statusline=response.getStatusLine();
		System.out.println("Status Line is:" +statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		
	}
	
	
	
}
