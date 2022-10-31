package com.featuredef.stepdef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.e2eapitests.CucumberSpringContextConfiguration;
import com.springboot.utils.AWSRestAssuredExtension;
import com.springboot.utils.Constants;
import com.springboot.utils.RestAssuredExtension;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UserStepDef extends CucumberSpringContextConfiguration{

	@Autowired
	public AWSRestAssuredExtension awsRestAssuredExtension;
	
	private RestAssuredExtension getRestExtension(String platform) throws Exception {
		switch(platform) {
		case "AWS":
			return awsRestAssuredExtension;
		default:
			throw new Exception("Platform not recognized");
		}
	}
	@Given("I get all user with {string}")
	public void i_get_all_user_with(String path) {
		if(awsRestAssuredExtension == null) {
			System.out.println("awsRestAssuredExtension NULL:::");
		}
		else {
			System.out.println("object created::::");
		}
		awsRestAssuredExtension.setArgs(Constants.ApiMethods.GET, path);

	} 
	@Then("execute API call - {string}")
	public void execute_API_call(String platform) {
		try {
			RestAssuredExtension restAssuredExtension = this.getRestExtension(platform);
			restAssuredExtension.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}

	}
	@Then("status call is {int} - {string}")
	public void statuscodeIs(Integer path, String platform) {
		try {
			RestAssuredExtension restAssuredExtension = this.getRestExtension(platform);
			int statusCode = restAssuredExtension.getResponse().getStatusCode();
			System.out.println("status code::: " + statusCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
