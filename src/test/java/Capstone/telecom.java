package Capstone;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class telecom {
	
	  String tokenvalue;
	  String tokenlogin;
  @Test(priority=1)
  public void AddnewUser() {
	 
	  
	  HashMap<String,Object> details = new HashMap<String,Object>();
	  details.put("firstName","Arti");
	  details.put("lastName","aarti123" );
	  details.put("email","artirthe@gmail.com" );
	  details.put("password","mypassword2804");
	  
	  Response res = given()
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
	          
	  .body(details)
	  
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
	  
	  res.then().log().body();
	  tokenvalue=res.jsonPath().getString("token");
	  
	  int code = res.getStatusCode();
	  Assert.assertEquals(code, 201);
	  System.out.println("Token generated is :" +tokenvalue);  
	  System.out.println("Status verified for ADDNEWUSER:" +code);  
  }
  
  @Test(priority=2)
  
  public void GetUserProfile() {
	  
	  System.out.println("Test for Bearer Token API");
	  
	  	Response res=given()
	  			.header("Content-Type","application/json")
				  .header("Accept", "application/json")
	  	.header("Authorization", tokenvalue)
	  	
	  	.when().get("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  
	  //log the response
	 
	  		res.then().log().body();
	  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
	  	 System.out.println("Status verified for  GetUserProfile :" +code);  
	  
	  
  }
  
  @Test(priority=3)
  
  public void UpdateUser() {
	  HashMap<String,Object> detailsupdated = new HashMap<String,Object>();
	  detailsupdated.put("firstName","ArtiAgarwal");
	  detailsupdated.put("lastName","aarti123" );
	  detailsupdated.put("email","artirthe@gmail.com" );
	  detailsupdated.put("password","mypassword2804");
	  
	  Response res = given()
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
	          
	  .body(detailsupdated)
	  .header("Authorization", tokenvalue)
	  	
	  	.when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  
	  //log the response
	 
	  		res.then().log().body();
	  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
	  	 System.out.println("Status verified for UpdateUser:" +code);  
	  
	  
  }
  
  @Test(priority=4)
  
  public void LoginUser() {
	  HashMap<String,Object> logindetails = new HashMap<String,Object>();
	  logindetails.put("email","artirthe@gmail.com" );
	  logindetails.put("password","mypassword2804" );
	  
	  
	  Response res = given()
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenvalue)
	          
	  .body(logindetails)
	 
	  	
	  	.when().post(" https://thinking-tester-contact-list.herokuapp.com/users/login");
	  
	  //log the response
	 
	  		res.then().log().body();
	  		tokenlogin=res.jsonPath().getString("token");
  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
  	 System.out.println("Status verified for LoginUser:" +code);
  }
	  
  
  @Test (priority=5)
  
  public void Addcontact() {
	  {
		 
	  HashMap<String,Object> contactdetails = new HashMap<String,Object>();
	  contactdetails.put("firstname","Mahesh");
	  contactdetails.put("lastname","Agarwal");
	  contactdetails.put("birthdate","1959-12-12");
	  contactdetails.put("email","MaheshAg@gmail.com");
	  contactdetails.put("phone","9760188378");
	  contactdetails.put("street1","107 sahukara");
	  contactdetails.put("street2","Bara bazaar");
	  contactdetails.put("city","Bareilly");
	  contactdetails.put("StateProvince","UP");
	  contactdetails.put("postalcode","243003");
	  contactdetails.put("country","India");
	  
	  Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	          
	  .body(contactdetails)
	 
	  	.when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  
	  //log the response
	  res.then().log().body();	
  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 201);
  	 System.out.println("Status verified for ADDcontact:" +code);
	  
	  }
  }
  
  @Test(priority=6)
  
  public void Getcontactlist() {
	  
	  Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	
	 
	  	.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  
	  //log the response
	  res.then().log().body();	
  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
  	 System.out.println("Status verified for Getcontactlist:" +code);
	  
  }
  
 @Test(priority=7)
  
  public void Getcontact() {
	 
	  Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	
	 
	  	.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts/");
	  
	  //log the response
	  res.then().log().body();	
  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
  	 System.out.println("Status verified for Getcontact:" +code);
	 
 }
 
 @Test(priority=8)
 
 public void Updatecontact() {
	 
	 HashMap<String,Object> contactdetails = new HashMap<String,Object>();
	  contactdetails.put("firstname","Maheshji");
	  contactdetails.put("lastname","Agaarwala");
	  contactdetails.put("birthdate","1969-09-12");
	  contactdetails.put("email","MaheshAg12@gmail.com");
	  contactdetails.put("phone","971098378");
	  contactdetails.put("street1","107 Qila");
	  contactdetails.put("street2","chota bazaar");
	  contactdetails.put("city","Indore");
	  contactdetails.put("StateProvince","MP");
	  contactdetails.put("postalcode","248997");
	  contactdetails.put("country","China");
  
	  Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	
			  .body(contactdetails)
	 
	  	.when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/");
	  
	  //log the response
	  res.then().log().body();	
  		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
  	 System.out.println("Status verified for Updatecontact:" +code);
  	 String email = res.jsonPath().getString("email");
  	 Assert.assertEquals(email,"MaheshAg12@gmail.com","Email not matched");
  	 System.out.println("Email matched");
  	
 
  }
 
@Test(priority=9)
 
 public void Updatecontactpartial() {
	
	 HashMap<String,Object> contactdetails = new HashMap<String,Object>();
	  contactdetails.put("firstname","MaheshKumar");
	  contactdetails.put("lastname","Agaarwala");
	  contactdetails.put("birthdate","1969-09-12");
	  contactdetails.put("email","MaheshAg12@gmail.com");
	  contactdetails.put("phone","971098378");
	  contactdetails.put("street1","107 Qila");
	  contactdetails.put("street2","chota bazaar");
	  contactdetails.put("city","Indore");
	  contactdetails.put("StateProvince","MP");
	  contactdetails.put("postalcode","248997");
	  contactdetails.put("country","China");

	  Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	
			  .body(contactdetails)
	 
	  	.when().patch("https://thinking-tester-contact-list.herokuapp.com/contacts/");
	  
	  //log the response
	  res.then().log().body();	
		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
	 System.out.println("Status verified for  Updatecontactpartial :" +code);
	
}
 @Test(priority=10)
 public void Logout() {
	 
	 Response res = given()	
			  .header("Content-Type","application/json")
			  .header("Accept", "application/json")
			  .header("Authorization", tokenlogin)
	
	 
	  	.when().post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
	  
	  //log the response
	  res.then().log().body();	
		int code = res.getStatusCode();
	  	  Assert.assertEquals(code, 200);
	 System.out.println("Status verified :" +code);
	 
 }



}
  
	 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

