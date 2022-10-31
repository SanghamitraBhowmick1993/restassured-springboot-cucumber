package com.springboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class AWSRestAssuredExtension extends RestAssuredExtension{
	public AWSRestAssuredExtension(@Value("${AWS_SERVICE_URL}") String baseUri) {
		super(baseUri);
	}
}
