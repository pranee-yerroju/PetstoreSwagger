package api.Tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.EndPoints.UserEndPoints;
import api.Payloads.User;
import io.restassured.response.Response;

public class userTests {
	
	Faker fake;
	User user;
	@BeforeClass
	public void setData() {
		fake=new Faker();
		user=new User();
		user.setId(fake.idNumber().hashCode());
		user.setUsername(fake.name().username());//String username;
		user.setFirstname(fake.name().firstName());//String firstname;
		user.setLastname(fake.name().lastName());//String lastname;
		user.setEmail(fake.internet().emailAddress());//String email;
		user.setPassword(fake.internet().password(5,10));//String password;
		user.setPhone(fake.phoneNumber().cellPhone());//String phone;
		//int userStatus=0;
	}
	@Test(priority=0)
	public void testCreateUser(ITestContext context) {
		Response response=UserEndPoints.createUser(user);
		response.then().log().all();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=1, enabled=true)
	public void testGetUserByName() {
		Response response=UserEndPoints.getUser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2, enabled=true)
	public void testUpdateUserByName() {
		user.setFirstname(fake.name().firstName());//String firstname;
		user.setLastname(fake.name().lastName());//String lastname;
		user.setEmail(fake.internet().emailAddress());//String email;
		user.setPassword(fake.internet().password(5,10));//String password;
		
		Response response=UserEndPoints.updateUser(this.user.getUsername(), user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Response response1=UserEndPoints.getUser(this.user.getUsername());
		response1.then().log().all();
		Assert.assertEquals(response1.getStatusCode(), 200);
	}
	@Test(priority=3, enabled=true)
	public void testDeleteUserByName() {
		Response response=UserEndPoints.deleteUser(this.user.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
