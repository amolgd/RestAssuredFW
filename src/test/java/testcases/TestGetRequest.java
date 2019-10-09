package testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TestGetRequest 
{
	
	@Test
	public void testGetRequest()
	{
		    // RestAssured.baseURI="";
		     Response response = given().
		    		 queryParam("q","title:DNA").
		     when().
		     get(" http://api.plos.org/search").
		     then().extract().response();
		     
		     String res = response.asString();
		     
		    JsonPath js = new JsonPath(res);
		    
		    String v = js.getString("response.numFound");
		    System.out.println(v);        
	}

}
