package api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.StoreEndPoints;
import api.Payloads.Store;
import io.restassured.response.Response;

public class storeTests {
	
	Faker fake;
	Store payload;
	@Test
	public void testcreateOrder() {
		fake=new Faker();
		payload=new Store();
		payload.setId(fake.idNumber().hashCode());
		payload.setPetId(fake.idNumber().hashCode());
		payload.setQuantity(fake.number().randomDigitNotZero());
		payload.setComplete(fake.funnyName().toString());
		
		Response response =StoreEndPoints.create_order(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	

}
