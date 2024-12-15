package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ques1asgmt {
	int id;
	
	
  @Test(priority = 1)
  public void getcall() {
	  
	  Response res = given()
			  .header("accept" ,"application/json")
			  
	  .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
	  
	  
	  res.then().log().body();
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for get call" +code);
	
	  
  }
  
  @Test (priority=2)
  
  public void postcall() {
	 
	  
	 Response res= given()
			 .header("accept", "application/json")
	          .header("Content-Type","application/json")
	          .body("{\n"
	      	  		+ "\"id\": 111,\n"
	      	  		+ "\"category\": {\n"
	      	  		+ "\"id\": 0,\n"
	      	  		+ "\"name\": \"string\"\n"
	      	  		+ "},\n"
	      	  		+ "\"name\": \"doggie\",\n"
	      	  		+ "\"photoUrls\": [\n"
	      	  		+ "\"string\"\n"
	      	  		+ "],\n"
	      	  		+ "\"tags\": [\n"
	      	  		+ "{\n"
	      	  		+ "\"id\": 0,\n"
	      	  		+ "\"name\": \"string\"\n"
	      	  		+ "}\n"
	      	  		+ "],\n"
	      	  		+ "\"status\": \"available\"\n"
	      	  		+ "}'\n"
	      	  		+ "Request URL\n"
	      	  		+ "https://petstore.swagger.io/v2/pet\n"
	      	  		+ "Server response\n"
	      	  		+ "Code Details\n"
	      	  		+ "200\n"
	      	  		+ "Response body\n"
	      	  		+ "{\n"
	      	  		+ "\"id\": 111,\n"
	      	  		+ "\"category\": {\n"
	      	  		+ "\"id\": 0,\n"
	      	  		+ "\"name\": \"string\"\n"
	      	  		+ "},\n"
	      	  		+ "\"name\": \"doggie\",\n"
	      	  		+ "\"photoUrls\": [\n"
	      	  		+ "\"string\"\n"
	      	  		+ "],\n"
	      	  		+ "\"tags\": [\n"
	      	  		+ "{\n"
	      	  		+ "\"id\": 0,\n"
	      	  		+ "\"name\": \"string\"\n"
	      	  		+ "}\n"
	      	  		+ "],\n"
	      	  		+ "\"status\": \"available\"\n"
	      	  		+ "}")
	      			 
	      	  
	  .when().post("https://petstore.swagger.io/v2/pet");
	  
	  res.then().log().body();
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for postcall" +code);
	 id= res.jsonPath().getInt("id");
	 System.out.println("id for the cpt created is :" + id);
	  
			
	  
  }
  
  @Test (priority=3)
  
  public void findpet() {
	  
	  Response res= given()
				 .header("accept", "application/json")
				 
				 .when().get("https://petstore.swagger.io/v2/pet/111");
	  res.then().log().body();
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for printing - Verified code is " + code);		 
				 
  }
  
  @Test (priority=4) // getting failed
  
  public void updatePet() {
	  
	  
	  Response res= given()
				 .header("accept", "application/json")
		          .header("Content-Type","application/json")
		          .body("{\n"
		          		+ "\"id\": 0,\n"
		          		+ "\"category\": {\n"
		          		+ "\"id\": 0,\n"
		          		+ "\"name\": \"string\"\n"
		          		+ "},\n"
		          		+ "\"name\": \"doggie\",\n"
		          		+ "\"photoUrls\": [\n"
		          		+ "\"string\"\n"
		          		+ "],\n"
		          		+ "\"tags\": [\n"
		          		+ "\"id\": 0,\n"
		          		+ "\"name\": \"string\"\n"
		          		+ "}\n"
		          		+ "],\n"
		          		+ "\"status\": \"available\"\n"
		          		+ "}")
		      			 
		      	  
		  .when().put("https://petstore.swagger.io/v2/pet/"+id);
		  
		  res.then().log().body();
		  int code = res.getStatusCode();
		  Assert.assertEquals(code, 200);
		  System.out.println("Status verified for Put call" +code);
		System.out.println("information updated successfully");
		  
	  
	  
	  
  }
  
@Test (priority =5)
  
  public void deletePet() {
	  
	  
	  Response res= given()
				 .header("accept", "application/json")
		         
				 .when().delete("https://petstore.swagger.io/v2/pet/111");
	  
                
	  res.then().log().body();
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for Delete call :" +code);
	  System.out.println("Data deleted");
  
}


}
