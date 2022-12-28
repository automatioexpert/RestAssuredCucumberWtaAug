package Actions;

import org.omg.CORBA.RepositoryIdHelper;
import org.testng.Assert;

import DataStore.Data;
import Payloads.CreateBookingRequest;
import Payloads.CreateBookingResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateBookingActions {
	
	Response response;
	CreateBookingResponse createBookingResponse;
	//ExtentTest test;
	

	
	
	public CreateBookingResponse createBooking(CreateBookingRequest createBookingRequest)
	{
		RestAssured.baseURI = Data.BASE_URL;
		RestAssured.basePath= Data.CREATE_BOOKING_BASEPATH;
		
		//test.info("Base URI is"+ RestAssured.baseURI);
		//test.info("Base Path is "+ RestAssured.basePath);
		
		//test.info("Payload is" + createBookingRequest);
		
		response = RestAssured
			.given()
			.body(createBookingRequest)
			.contentType(ContentType.JSON)
			.log()
			.all()
			.post().then().log().all().extract().response();
		
		//test.info("Status code is : "+ response.getStatusCode());
		
		createBookingResponse = response.as(CreateBookingResponse.class);
		return createBookingResponse;
	}
	
//	public boolean verifyStatusCodeAs(int expectedStatusCode)
//	{
//		int actualCode = response.getStatusCode();
//		boolean flag = expectedStatusCode == actualCode;
//		if(flag)
//			test.pass("Status code is as expected as "+ expectedStatusCode);
//		else
//			test.fail("Status code is not as expected as "+expectedStatusCode);	
//		return flag;
//	}
//	
//	public boolean verifyBookingIdGenerated() {
//		int bookingId = createBookingResponse.getBookingid();
//		boolean flag = bookingId > 0;
//		if(flag)
//			//test.pass("Booking id is proper as "+ bookingId);
//		else
//			test.fail("Booking id is not proper as "+bookingId);	
//		return flag;
//		
//	}

}
