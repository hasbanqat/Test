package apiRA;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_Request {

	@Test
	void getGoogleMAP() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	String responseBody=response.getBody().asString();
	System.out.println("Response body is:" +responseBody);

	String contentType=response.header("Content-Type");
	System.out.println("Content-Type is: " +contentType);
	Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
	
	String contentEncoding=response.header("Content-Encoding");
	System.out.println("Content-Encoding is: " +contentEncoding);
	Assert.assertEquals(contentEncoding, "gzip");
	
	
	String serverTiming=response.header("Server-Timing");
	System.out.println("Server-Timing is: " +serverTiming);
	Assert.assertEquals(serverTiming, serverTiming);
	
	
	}
}
