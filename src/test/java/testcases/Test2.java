package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import Base.Base;
import Utilities.Utility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test2 extends Base
{

	@Test
	public void verifyCreateIssueAPI()
	{
		
		//Get token
	    String key = Utility.getAuthKey();
	    System.out.println(key);
	    
	    //create issue
	    
	    Response res =given().  
	              header("Content-Type","application/json").
	              header("Cookie","SESSIONID="+key).
	              body("{\n" +
	            	        "    \"fields\": {\n" +
	            	        "       \"project\":\n" +
	            	        "       {\n" +
	            	        "          \"key\": \"RF\"\n" +
	            	        "       },\n" +
	            	        "       \"summary\": \"REST ye merry gentlemen.\",\n" +
	            	        "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n" +
	            	        "       \"issuetype\": {\n" +
	            	        "          \"name\": \"Bug\"\n" +
	            	        "       }\n" +
	            	        "   }\n" +
	            	        "}"). 
	    when().
	             post("rest/api/2/issue").then().extract().response();
	    String response = res.asString();
	    System.out.println(response);
	    JsonPath js = new JsonPath(response);
	    System.out.println(js.get("id"));
	             
	}
}
