package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ques3 {
	  @Test
	  public void Oauth2Test()
	  {
		  
		  Response res=given()
		  .auth().oauth2("Bearer 23232323")
		  
		  .when().get("https://postman-echo.com");
		  
		 int code=res.getStatusCode();
		 Assert.assertEquals(code,200);
		 System.out.println("Staus code is : "+code);

		 res.then().log().body();
		  
		  
	  }
}
