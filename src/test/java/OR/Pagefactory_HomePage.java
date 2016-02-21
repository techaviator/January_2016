package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_HomePage {
	//driver.findElement(By.linkText("Sign In")).click();
	//driver.findElement(By.xpath("//span[@id='username']/a"))
	//driver.findElement(By.id("srchword")).sendKeys(Search_Item);
	///driver.findElement(By.className("newsrchbtn")).click();
	//driver.findElement(By.className("sorrymsg")).getText();
	//driver.findElement(By.id("find")).getText();
	@FindBy(linkText = "Sign In")
	private WebElement SignIn;
	
	@FindBy(xpath = "//span[@id='username']/a")
	private WebElement Valid_user;
	
	
	@FindBy (id="srchword")
	private WebElement SearchKeyword;
	
	@FindBy(className= "newsrchbtn")
	private WebElement Searchbutton;
	
	@FindBy (className ="sorrymsg")
	private WebElement invalid_search_msg;
	
	@FindBy (id="find")
	private WebElement valid_search_msg;
	
	public Pagefactory_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_SignIn()
	{
		SignIn.click();
	}
	
	public String getValidUseMsg()
	{
		return Valid_user.getText();
	}
	
	public void Enter_SearchText(String searchkey)
	{
		SearchKeyword.sendKeys(searchkey);
	}
	
	public void Click_Search_Button()
	{
		Searchbutton.click();
	}
	
	public String get_Invalid_Search_msg()
	{
		return invalid_search_msg.getText();
	}
	
	public String get_valid_Search_msg()
	{
		return valid_search_msg.getText();
	}
	
}
