package StepDefinitions;

import java.util.HashMap;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CRUDStepDefinitions {
	
	RequestSpecification request;
	Response response;
	HashMap<String,Object> emp;
	
		
		@Given("The base URI is {string}")
		public void the_base_URI_is(String URI) {
		    
			request = RestAssured.given().baseUri(URI);
		}
		
		@When("I perform the Get Operation")
		public void i_perform_the_Get_Operation() {
		   response = request.get();
		   System.out.println(response.getBody());
		}
		
		@Then("Response code should be {int}")
		public void response_code_should_be(int Statuscode) {
			
			Assert.assertEquals(Statuscode, response.getStatusCode());
		    
		}
		
		@Given("The base URI is for post  {string}")
		public void the_base_URI_is_for_post(String URI) {
		    request = RestAssured.given().baseUri(URI);
		}
		

		@When("The username {string} , salary of employee {string}")
		public void the_username_salary_of_employee_and_age_of_employee(String empname, String empsal) {
		   
			emp= new HashMap<String,Object>();
			emp.put("name", empname);
			emp.put("salary", empsal);
			
		}
		
		@And("I perform the Post Operation")
		public void i_perform_the_Post_Operation() {
			
			response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(emp).post("/create");

		}

		

		@Then("Response code is {int}")
		public void response_code_is(Integer int1) {
		    
			Assert.assertEquals(201, response.getStatusCode());
		}

		
		
}
