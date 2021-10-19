package testPack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.filter.session.SessionFilter;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.ValidatableResponse;

public class formAuth {
	
	public String code;
	static ValidatableResponse accessToken;
	public static final String clientId="37729d48-13bb-4759-a6f2-0f4bbed50bb4";
	public static final String clientSecret="";
	
	
	public static SessionFilter filter;
	@BeforeClass
	public static void init() {
		filter=new SessionFilter();
		RestAssured.baseURI="https://v1.api.us.janrain.com/ec99d7d1-3a3c-4c92-a69c-e54650678ea1";
		RestAssured.given().auth().form("user", "pass", new FormAuthConfig("/login/token","hemantsaroj@rightpoint.com","Hemant123"))
		.get();
		
		System.err.println(filter.getSessionId());;
		
		
	}

	@Test
	public void getCode() {
		
				
		
		
		
		
	}
  @Test
  public void getAccessToken() {
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
	  
  }
}
