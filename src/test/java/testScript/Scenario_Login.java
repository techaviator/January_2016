package testScript;

import generic.Base_Class;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OR.Pagefactory_HomePage;
import OR.Pagefactory_LoginPage;



public class Scenario_Login extends Base_Class{
	
	@Test(dataProvider = "Invalid_Login",dataProviderClass=dataProvider.DP_Login.class, groups={"Regression"})
	public void InvalidLogin(String TC_ID, String Order, String uname, String pwd, String expected)
	{		
		
		System.out.println("Start invalid login");
		//driver.findElement(By.linkText("Sign In")).click();
		Pagefactory_HomePage home = new Pagefactory_HomePage(driver);
		home.Click_SignIn();
		//driver.findElement(By.name("logid")).sendKeys(uname);
		//driver.findElement(By.name("pswd")).sendKeys(pwd);
		//driver.findElement(By.cssSelector("td[class='sb1'] input")).click();
		//String invalidmsg = driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
		
		
		Pagefactory_LoginPage login = new Pagefactory_LoginPage(driver);
		login.Enter_Username(uname);
		login.Enter_password(pwd);
		login.Click_login();
		String invalidmsg = login.Invalid_Login_message();		
		System.out.println(invalidmsg);
		Assert.assertEquals(expected, invalidmsg);
		
	}
	
	@Test(dataProvider = "valid_Login",dataProviderClass=dataProvider.DP_Login.class,groups={"SmokeTest","Regression"})
	public void ValidLogin(String TC_ID, String Order, String uname, String pwd, String expected)
	{
		Pagefactory_HomePage home = new Pagefactory_HomePage(driver);
		home.Click_SignIn();
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(uname);
		driver.findElement(By.name("pswd")).sendKeys(pwd);
		driver.findElement(By.cssSelector("td[class='sb1'] input")).click();
		String validmsg = driver.findElement(By.xpath("//span[@id='username']/a")).getText();*/
		
		Pagefactory_LoginPage login = new Pagefactory_LoginPage(driver);
		login.Enter_Username(uname);
		login.Enter_password(pwd);
		login.Click_login();
		String validmsg = home.getValidUseMsg();
		SoftAssert asst = new SoftAssert();
		asst.assertEquals(validmsg, expected);
		//System.out.println("Print this line to show softassert");
		//asst.assertEquals(1, 2);
		//System.out.println("Print this line to show softassert again");
		asst.assertAll();
		
	}

}




