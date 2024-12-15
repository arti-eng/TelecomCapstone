package com.restAssured;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ques2asgmt {
  @Test
  public void createPostusingPojo() {
	  
	  //Request Payload
	  PojoData data = new PojoData();

	  data.setYear(2024);
	  data.setPrice(50000.89);
	  data.setCPUmodel("Intel Latest");
	  data.setHarddisksize("2TB");
	  
	  
	  PojoDetailsQues2 details = new PojoDetailsQues2();
	  details.setName("Arti");
	  details.setData(data);
	  
	  
	  Response res = given()
			  .header("Content-Type", "application/json")
			  .body(details)
			  
	  .when().post("https://api.restful-api.dev/objects");
	  
	 res .then().log().body();
	 int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for post call using POJO" +code);  
	  
  }
  @Test (priority=1)
  public void createPostusingHashmaap() {
	 
	  
	  HashMap<String,Object> map = new HashMap<String,Object>();
	  map.put("name", "Apple MacBook Pro 16");
	  
	  HashMap<String,Object> details = new HashMap<String,Object>();
	  details.put("year", 2019);
	  details.put("price",1849.99);
	  details.put("CPUmodel","Intel Core i9");
	  details.put("Harddisksize","1 TB");
	  map.put("data", details);
	  
	  Response res = given()
			  .header("Content-Type", "application/json")
			  .body(map)
			  
	  .when().post("https://api.restful-api.dev/objects");
	  
	 res .then().log().body();
	 int code = res.getStatusCode();
	  Assert.assertEquals(code, 200);
	  System.out.println("Status verified for post call using Hashmap" +code);  
	  
	  
  }
  
  
}
