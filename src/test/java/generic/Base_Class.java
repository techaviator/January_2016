package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	
	public WebDriver driver = null;
	@BeforeMethod(groups ={"SmokeTest","Regression"})
	public void launchbrowser()
	{
		String browsertype =UtilityClass.getPropertyfile("browsertype");
		if (browsertype.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", UtilityClass.getPropertyfile("IEdriver"));
			driver=new InternetExplorerDriver();
		}
		else if (browsertype.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("Webdriver.chrome.driver", "D:\\JavaWorkspace_2016\\Jan_2016_batch\\January_Framework\\src\\test\\resources\\chromedriver.exe");
			System.setProperty("Webdriver.chrome.driver", UtilityClass.getPropertyfile("chromedriver"));
			driver=new ChromeDriver();
		}
		else if (browsertype.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(UtilityClass.getPropertyfile("URL"));
	}
	
	@AfterMethod (groups ={"SmokeTest","Regression"})
	public void tear_down()
	{
		driver.quit();
	}

}
