package api.EndPoints;
import static io.restassured.RestAssured.given;

import api.Payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response create_order(Store payload) {
		
		  Response response=given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .body(payload)
		           .when()
		           .post(Routes.store_create_url);
		  return response;
	}
	public static Response find_order(String orderID) {
		
		  Response response=given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("orderId", orderID)
		           .when()
		           .get(Routes.store_get_url);
		  return response;
	}
	public static Response update_order(String orderID, Store payload) {
		
		  Response response=given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("orderId", orderID)
				  .body(payload)
		           .when()
		           .put(Routes.store_update_url);
		  return response;
	}
	public static Response delete_order(String orderId) {
		
		  Response response=given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("orderId", orderId)
		           .when()
		           .delete(Routes.store_delete_url);
		  return response;
	}

}
