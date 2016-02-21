package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getPropertyfile(String key)
	{
		FileInputStream fis =null;
		try {
			 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}
	
	/*public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		System.out.println(getPropertyfile("URL"));
		
	}
	*/

}
