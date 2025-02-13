package api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.PetEndPoints;
import api.Payloads.Pet;
import io.restassured.response.Response;

public class petTests {
	
	Faker fake;
	Pet payload;
	@Test(priority=1)
	public void testPetCreate() {
		fake=new Faker();
		payload=new Pet();
		
		payload.setId(fake.idNumber().hashCode());
		payload.setName(fake.name().fullName());
		payload.setPetId(fake.idNumber().hashCode());
		payload.setStatus("true");
		payload.setUrl(fake.internet().url());
		
		Response response=PetEndPoints.create_pet(payload);
		response.then().log().all();
		
	}
	@Test(priority=2)

	public void testGetPetDetails() {
		
		Response response=PetEndPoints.get_pet(2);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)

	public void testupdatePetDetails() {
		fake=new Faker();
		payload=new Pet();
		
		payload.setName(fake.name().fullName());
		payload.setStatus("true");
		payload.setUrl(fake.internet().url());
		
		Response response=PetEndPoints.update_pet(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=4)

	public void testDeletePetDetails() {
		fake=new Faker();
		
		Response response=PetEndPoints.delete_pet(2);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
