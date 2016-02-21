package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_LoginPage {
	
	/*driver.findElement(By.name("logid")).sendKeys(uname);
	driver.findElement(By.name("pswd")).sendKeys(pwd);
	driver.findElement(By.cssSelector("td[class='sb1'] input")).click();
	driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
	*/
	@FindBy (name="logid")
	private WebElement Login_Textbox;
	
	@FindBy(name= "pswd")
	private WebElement Password;
	
	@FindBy(css = "td[class='sb1'] input" )
	private WebElement LoginButton;
	
	@FindBy(xpath ="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	private WebElement Invalidmsg;
	
	
	public Pagefactory_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_Username(String uname)
	{
		Login_Textbox.sendKeys(uname);
	}
	
	public void Enter_password(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void Click_login()
	{
		LoginButton.click();
	}
	
	public String Invalid_Login_message()
	{
		return Invalidmsg.getText();
	}
	
	
	
	
	
	

}
