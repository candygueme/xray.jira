package test.jira.xray;




import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefinitions {

	@Given("^I have (\\d+) cukes in my belly$")
	public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
		System.out.println("GIVEN");
	}

	@When("^I wait (\\d+) hour$")
	public void I_wait_hours(int hours) throws Throwable {
		System.out.println("WHENd");
		Thread.sleep(hours * 0);
	}

	@Then("^my belly should growl$")
	public boolean my_belly_should_growl() throws Throwable {
		System.out.println("THEN");
		return true;
	}

	@AfterAll
	public static void afterTest() throws IOException {
		String TOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiIwMjQ1NDhmYS04NTNjLTM3YmQtODNhNi02ZThkNzRhNmFiMzgiLCJhY2NvdW50SWQiOiI2MjczN2M1N2U1MWM2MjAwNzBiZTc5OGEiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY2OTI5ODQ3NCwiZXhwIjoxNjY5Mzg0ODc0LCJhdWQiOiIxMzIyNkY4NkExNzk0OTU3ODRBRjg2RUY2RDM4Rjc5OSIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IjEzMjI2Rjg2QTE3OTQ5NTc4NEFGODZFRjZEMzhGNzk5In0.KSd_rQCGMcPMRiTCOevlFZL2oeV6vcFhZAu3vMS4tJg";

	String FilePath="C:\\Users\\candy.guerrero\\eclipse-workspace\\xray.jira\\target\\surefire-reports\\TEST-test.jira.xray.RunCucumberTest.xml";
					String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
					Response result =  RestAssured.with().given().header("Authorization", "Basic " + TOKEN).contentType(ContentType.JSON)
					.body(XMLBodyToPost).when()
				.post("https://xray.cloud.getxray.app/api/v2/import/execution/junit?projectKey=TX");
		
	System.out.println(result.getStatusCode());
	}
}
