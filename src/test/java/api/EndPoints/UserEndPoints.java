package api.EndPoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	static ResourceBundle getURL(){
		ResourceBundle resource=ResourceBundle.getBundle("routes");
		return resource;
	}
	
	public static Response createUser(User Payload){
		String create_url=getURL().getString("create_url");
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
		        .when()
		        .post(create_url);
		        return response;
	}
	public static Response getUser(String username){
		String read_url=getURL().getString("get_url");
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
		        .when()
		        .get(read_url);
		        return response;
	}
	public static Response updateUser(String Username, User Payload){
		String update_url=getURL().getString("update_url");
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", Username)
				.body(Payload)
		        .when()
		        .put(update_url);
		        return response;
	}
	public static Response deleteUser(String Username){
		String delete_url=getURL().getString("delete_url");
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", Username)
		        .when()
		        .delete(delete_url);
		        return response;
	}

}
