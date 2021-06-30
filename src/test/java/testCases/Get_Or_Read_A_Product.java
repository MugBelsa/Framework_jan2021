package testCases;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Or_Read_A_Product {

	// object of softAssert class

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void read_A_Product() {
		
	

		// http://techfios.com/api-prod/api/product/read_one.php?id=1209

		Response response = 
			given()

				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.queryParam("id", "2041")
			.when()
				.get("/read_one.php")
			.then()
			    .extract().response();
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody : " + responseBody);
		
		
//		String responseHeader = response.getHeader("content-type");
//		//System.out.println(responseHeader);
//		
//		softAssert.assertEquals(responseHeader, "application/json");
//		softAssert.assertEquals(responseHeader, "application/json", "Header missmatch");

//		JsonPath js = new JsonPath(responseBody);
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
		softAssert.assertAll();
  
		
		
		
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
