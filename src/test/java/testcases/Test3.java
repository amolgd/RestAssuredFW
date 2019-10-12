package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Base.Base;
import Utilities.Utility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test3 extends Base
{
       @Test
       public void verifyAddCommentAPI()
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
   	              		"    \"body\": \"This is a comment that only administrators can see.\",\r\n" + 
   	              		"    \"visibility\": {\r\n" + 
   	              		"        \"type\": \"role\",\r\n" + 
   	              		"        \"value\": \"Administrators\"\r\n" + 
   	              		"    }\r\n" + 
   	              		"}"). 
   	    when().
   	             post("/rest/api/2/issue/RF-7/comment").then().statusCode(201).extract().response();
   	    String response = res.asString();
	    System.out.println(response);
	    JsonPath js = new JsonPath(response);
	    System.out.println(js.get("id"));
       }
}
