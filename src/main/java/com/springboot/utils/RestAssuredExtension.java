package com.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

@Component
public class RestAssuredExtension {
	public String baseUri;
	private String method;
	private String path;
	private String url;
	private ResponseOptions<Response> response;
	private Object requestBody;
	RestAssuredExtension restAssuredExtension;

//	@Value("${JWT}")
//	private String jwt;
	// private RequestSpecBuilder builder = new RequestSpecBuilder();

	@Autowired()
	public AWSRestAssuredExtension awsRestAssuredExtension;
	
	private RequestSpecBuilder builder = new RequestSpecBuilder();

	public RestAssuredExtension(String baseUri) {
		this.baseUri = baseUri;
	}

	public void setArgs(String method, String path) {
		this.method = method;
		this.url = this.baseUri + path;
	}

	public ResponseOptions<Response> execute() {
		return executeAPI();
	}
	public Object getRequestBody() {
		return this.requestBody;
	}
	public void addBody(Object obj) {
		this.requestBody = obj;
		builder.setBody(obj);
	}

	public ResponseOptions<Response> executeAPI() {
		ResponseOptions<Response> response = null;
		RequestSpecification requestSpec = builder.build();
		RequestSpecification request = RestAssured.given();
		request.spec(requestSpec);
		request.contentType(ContentType.JSON);
		request.relaxedHTTPSValidation();

		// request.header("Authorization","Bearer " + jwt);
		// request.proxy("10.1.162.6", 8080);

		try {
			if (this.method.equalsIgnoreCase(Constants.ApiMethods.GET)) {
				response = request.get(this.url);
			} else if (this.method.equalsIgnoreCase(Constants.ApiMethods.POST)) {
				response = request.post(this.url);
			} else if (this.method.equalsIgnoreCase(Constants.ApiMethods.PUT)) {
				response = request.put(this.url);
			} else if (this.method.equalsIgnoreCase(Constants.ApiMethods.PATCH)) {
				response = request.patch(this.url);
			} else if (this.method.equalsIgnoreCase(Constants.ApiMethods.DELETE)) {
				response = request.delete(this.url);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.response = response;
		return response;
	}

	public ResponseOptions<Response> getResponse(){
		return this.response;

	}
	public void cleanup() {
		builder = new RequestSpecBuilder();
		url =null;
		response = null;
		requestBody = null;
	}
}
