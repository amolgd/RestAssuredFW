package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base 
{
	
	public static Properties ps = new Properties();
	
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\resource.properties");
		ps.load(fis);
	}

}
