package testCases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Get_Or_Read_All_Products {

	@Test
	public void read_All_Product() {

		// http://techfios.com/api-prod/api/product/read.php

		Response response = given()

				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8").when().get("/read.php").then().extract()
				.response();

		int statusCode = response.getStatusCode();
		System.out.println("Status code :" + statusCode);

		Assert.assertEquals(statusCode, 200);

//		response.getBody().prettyPrint();

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

	}

}
