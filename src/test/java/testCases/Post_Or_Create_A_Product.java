package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_Or_Create_A_Product {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void create_A_Product() {

		// http://techfios.com/api-prod/api/product/create.php

		HashMap<String,String> payload = new HashMap<String, String>();

		payload.put("name", "Iphone");
		payload.put("price", "1200");
		payload.put("description", "Nice Iphone ever");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");

		Response response = 
				given()
//				     .log().all()
				     .baseUri("https://techfios.com/api-prod/api/product")
			       	 .header("Content-Type", "application/json; charset=UTF-8")
				     .body(payload)
				.when()
				     .post("/create.php")
				.then() 
//				     .log().all()
				     .extract()
				     .response();
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody : " + responseBody);

////	
////		JsonPath js = new JsonPath(responseBody);
////		//js.prettyPrint();
////		
////		String productId = js.getString("id");
////		String productName = js.getString("name");
////		String productDescription = js.getString("description");
////		
////		Assert.assertEquals(productId,"1209");
////		Assert.assertEquals(productName,"HP Laptop Elite Pro");
////		Assert.assertEquals(productDescription,"Super fast laptop");
////		
////		
//		softAssert.assertAll();
////		
////		
//		int statusCode = response.getStatusCode();
//		System.out.println("Status code :" + statusCode);
//
//		// Assert.assertEquals(statusCode, 201);
//		softAssert.assertEquals(statusCode, 201);
///
////		// response.getBody().prettyPrint();
////
////		String responseBody = response.getBody().asString();
////		System.out.println("ResponseBody : " + responseBody);
////
////		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
////		System.out.println("Response Time : " + responseTime);
////
////		if (responseTime <= 2000) {
////			System.out.println("Response time is within the range");
////
////		} else {
////			System.out.println("Not acceptable!!!");
////		}

	}

}
