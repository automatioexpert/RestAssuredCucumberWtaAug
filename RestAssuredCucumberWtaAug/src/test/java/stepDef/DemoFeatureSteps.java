package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoFeatureSteps {

	@Given("some precondition")
	public void some_precondition() {
	   System.out.println("Some preconditions performed");
	}

	@When("something is done")
	public void something_is_done() {
	    System.out.println("Something is done by user");
	}

	@Then("something is expected")
	public void something_is_expected() {
	    System.out.println("expectation is full filled");
	}
}
