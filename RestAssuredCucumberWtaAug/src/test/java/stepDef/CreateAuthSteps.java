package stepDef;

import java.util.List;
import java.util.Map;

import Actions.CreateBookingActions;
import Actions.GenerateAuthActions;
import DataStore.Data;
import Payloads.GenerateAuthRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class CreateAuthSteps {
	
	GenerateAuthRequests generateAuthRequests;
	GenerateAuthActions generateAuthActions;
	
	@Given("user sets the base URL")
	public void user_sets_the_base_url() {
	    RestAssured.baseURI = Data.BASE_URL;
	}

	@Given("user sets base path as {string}")
	public void user_sets_base_path_as(String basePath) {
	    RestAssured.basePath = basePath;
	}

	@When("user provides below data for creating booking")
	public void user_provides_below_data_for_creating_booking(List<Map<String,String>> dataTable) {
	    generateAuthRequests = new GenerateAuthRequests();
	    generateAuthRequests.setUsername(dataTable.get(0).get("username"));
	    generateAuthRequests.setPassword(dataTable.get(0).get("password"));
	}

	@When("user hits create auth API")
	public void user_hits_create_auth_api() {
	    generateAuthActions = new GenerateAuthActions();
	    generateAuthActions.generateAuthToken(generateAuthRequests);
	}

	@Then("user verifies status code as {int}")
	public void user_verifies_status_code_as(Integer expectedStatusCode) {
	    generateAuthActions.verifyStatusCodeAs(expectedStatusCode);
	}

}
