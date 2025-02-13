package api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.EndPoints.UserEndPoints;
import api.Payloads.User;
import api.Utilities.DataProviders;
import io.restassured.response.Response;

public class DDTUserTest {
	
	
	//create
	@Test(priority=0, dataProvider="data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String Username, String firstname, String lastname, String email, String password, String phone, String status) {
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(Username);
		userpayload.setFirstname(firstname);
		userpayload.setLastname(lastname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		userpayload.setUserStatus(Integer.parseInt(status));
		
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//read
	@Test(priority=0, dataProvider="usernames",dataProviderClass=DataProviders.class)
	public void testGetUser(String Username) {
		
		Response response=UserEndPoints.getUser(Username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
			
	}
	//update
	@Test(priority=0, dataProvider="usernames",dataProviderClass=DataProviders.class)
	public void testUpdateUser(String userID, String Username, String firstname, String lastname, String email, String password, String phone, String status) {
		User userpayload=new User();
		
		userpayload.setFirstname(firstname);
		userpayload.setLastname(lastname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		userpayload.setUserStatus(Integer.parseInt(status));
		
		Response response=UserEndPoints.updateUser(Username, userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		Response response1=UserEndPoints.getUser(Username);
		response1.then().log().body();
	}
	//delete
	@Test(priority=0, dataProvider="usernames",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String Username) {
		
		Response response=UserEndPoints.deleteUser(Username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
			
	}

}
