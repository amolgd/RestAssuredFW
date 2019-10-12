package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Base.Base;
import Utilities.Utility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test4 extends Base
{
	  @Test
      public void verifyUpdateCommentAPI()
      {
   	   String key = Utility.getAuthKey();
  	       System.out.println(key);
  	       String cookie = "JSESSIONID="+key;
  	       System.out.println(cookie);
  	    
  	    //create issue  
  	    RestAssured.baseURI = ps.getProperty("JIRAHOST");
  	    Response res = given().  
  	             
  	              header("Content-Type","application/json").
  	              header("Cookie",cookie).
  	              body("{\r\n" + 
  	              		"    \"body\": \"This is a comment that only administrators can see updated.\",\r\n" + 
  	              		"    \"visibility\": {\r\n" + 
  	              		"        \"type\": \"role\",\r\n" + 
  	              		"        \"value\": \"Administrators\"\r\n" + 
  	              		"    }\r\n" + 
  	              		"}"). 
  	    when().
  	             put("/rest/api/2/issue/RF-7/comment/10007").then().statusCode(200).extract().response();
      }


}
