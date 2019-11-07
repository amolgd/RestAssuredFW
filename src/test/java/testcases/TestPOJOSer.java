package testcases;
import Utilities.GetJsonPaylod;
import Utilities.Courses;

public class TestPOJOSer 
{
	public static void main(String args[])
	{
		
		Courses c = new Courses();
		c.setWebAutomation("Selenium");
		c.setMobile("Appium");
		c.setApi("rest");
	
		GetJsonPaylod g = new GetJsonPaylod();
		g.setCourses(c);
		g.setExpertise("Testing");
		g.setUrl("www.training.com");
		g.setInstructor("amol");
		g.setLinkedin("amol gore");
		g.setServices("bla bla bla");
		
		Courses c1 = g.getCourses();
		System.out.println(c1.getApi());
		
	}

}
