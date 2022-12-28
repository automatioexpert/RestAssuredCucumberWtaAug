package Actions;

import DataStore.Data;
import Payloads.CreateBookingRequest;
import Payloads.CreateBookingResponse;
import Payloads.GenerateAuthRequests;
import Payloads.GenerateAuthResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenerateAuthActions {
	
	Response response;
	GenerateAuthResponse generateAuthResponse;
	
	
	
	
	
	public GenerateAuthResponse generateAuthToken(GenerateAuthRequests generateAuthRequests)
	{
		RestAssured.baseURI = Data.BASE_URL;
		RestAssured.basePath= Data.CREATE_AUTH;
		
		//test.info("Base URI is"+ RestAssured.baseURI);
		//test.info("Base Path is "+ RestAssured.basePath);
		
		//test.info("Payload is" + generateAuthRequests);
		
		response = RestAssured
			.given()
			.body(generateAuthRequests)
			.contentType(ContentType.JSON)
			.log()
			.all()
			.post().then().log().all().extract().response();
		
		//test.info("Status code is : "+ response.getStatusCode());
		
		generateAuthResponse = response.as(GenerateAuthResponse.class);
		return generateAuthResponse;
	}
	
	public boolean verifyStatusCodeAs(int expectedStatusCode)
	{
		int actualCode = response.getStatusCode();
		boolean flag = expectedStatusCode == actualCode;
//		if(flag)
//			test.pass("Status code is as expected as "+ expectedStatusCode);
//		else
//			test.fail("Status code is not as expected as "+expectedStatusCode);	
		return flag;
	}
	
	

}
