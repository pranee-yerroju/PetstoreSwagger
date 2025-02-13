package api.EndPoints;

import static io.restassured.RestAssured.given;

import api.Payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response create_pet(Pet payload) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.pet_create_url);
				return response;
	}
	public static Response get_pet(int petID) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("petId", petID)
				.when()
				.get(Routes.pet_get_url);
				return response;
	}
	public static Response update_pet(Pet payload) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.put(Routes.pet_update_url);
				return response;
	}
	public static Response delete_pet(int petID) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("petId", petID)
				.when()
				.delete(Routes.pet_delete_url);
				return response;
	}

}
