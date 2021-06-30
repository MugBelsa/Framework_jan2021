package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete_A_Product {

	// object of softAssert class
	Get_Or_Read_A_Product readProd = new Get_Or_Read_A_Product();
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void delete_A_Product() {

		//https://techfios.com/api-prod/api/product/delete.php

		HashMap<String, String> payload = new HashMap<String, String>();
		
		payload.put("id", "2037");
		
		Response response = 
			given()

				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(payload)
			.when()
				.delete("/delete.php")
			.then()
			    .extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody : " + responseBody);
		
	
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
		softAssert.assertEquals(message, "Product was deleted.", "not matching the assertion!!!");
		
		readProd.read_A_Product();
		
		softAssert.assertAll();
	
		
		
//		//js.prettyPrint();
//		
//		String productId = js.getString("id");
//		String productName = js.getString("name");
//		String productDescription = js.getString("description");
//		
//		Assert.assertEquals(productId,"1209");
//		Assert.assertEquals(productName,"HP Laptop Elite Pro");
//		Assert.assertEquals(productDescription,"Super fast laptop");
//		
		
		
//		
		
		
		
//		int statusCode = response.getStatusCode();
//		System.out.println("Status code :" + statusCode);
//
//		// Assert.assertEquals(statusCode, 201);
//		softAssert.assertEquals(statusCode, 201);
//
//		// response.getBody().prettyPrint();
//
//		String responseBody = response.getBody().asString();
//		System.out.println("ResponseBody : " + responseBody);
//
//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("Response Time : " + responseTime);
//
//		if (responseTime <= 2000) {
//			System.out.println("Response time is within the range");
//
//		} else {
//			System.out.println("Not acceptable!!!");
//		}

	}

}
