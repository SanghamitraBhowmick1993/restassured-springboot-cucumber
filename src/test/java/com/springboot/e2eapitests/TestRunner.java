package com.springboot.e2eapitests;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.utils.AWSRestAssuredExtension;

import io.cucumber.java.Before;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
public class TestRunner {

	@Autowired
		AWSRestAssuredExtension awsRestAssuredExtension;
	
//	@Before
//	public void cleanUp() {
//		awsRestAssuredExtension.cleanup();
//	}



}
