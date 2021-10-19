package testPack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class DemoTest {
	
	static ValidatableResponse accessToken;
	public static final String clientId="37729d48-13bb-4759-a6f2-0f4bbed50bb4";
	public static final String clientSecret="";
	
	
  @Test
  public void getToken() {
	accessToken=  RestAssured.given()
	  .params("grant_type", "client_credentials")
	  .auth()
	  .preemptive()
	  .basic(clientId, clientSecret)
	  .when()
	  .post("https://v1.api.us.janrain.com/ec99d7d1-3a3c-4c92-a69c-e54650678ea1/login/token")
	  .then()
	  .log()
	  .all();
	 // .extract()
	// .path("access_token");
	//System.out.println("The token is: "+accessToken);
	  
  }
}
