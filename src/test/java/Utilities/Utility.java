package Utilities;

import static io.restassured.RestAssured.given;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utility extends Base
{
    
	//amol123
	//Jira@123
	public static String getAuthKey()
	{
		 RestAssured.baseURI=ps.getProperty("JIRAHOST");
	     Response res = given().
	     						header("Content-Type","application/json"). 
	     						body("{\"username\":\"amol123\",\"password\":\"Jira@123\"}").
	     				when(). 
	     						post("/rest/auth/1/session"). 
	     				then(). 
	     						extract().response();
	                    
	     String response = res.asString();
	     JsonPath js = new JsonPath(response);
	     return js.get("session.value");
	}
}
