package testScript;

import generic.Base_Class;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import OR.Pagefactory_HomePage;

public class Scenario_Search extends Base_Class {
	
	@Test(dataProvider = "Invalid_Search", dataProviderClass = dataProvider.DP_Search.class)
	public void InvalidSearch(String TC_ID, String Order, String Search_Item, String expected)
	{
		/*driver.findElement(By.id("srchword")).sendKeys(Search_Item);
		driver.findElement(By.className("newsrchbtn")).click();
		String invalidsearch = driver.findElement(By.className("sorrymsg")).getText();*/
		
		Pagefactory_HomePage home = new Pagefactory_HomePage(driver);
		home.Enter_SearchText(Search_Item);
		home.Click_Search_Button();
		String invalidsearch = home.get_Invalid_Search_msg();
		System.out.println(invalidsearch);
		SoftAssert asst = new SoftAssert();
		asst.assertEquals(invalidsearch, expected);
		asst.assertAll();
	}
	
	@Test(dataProvider = "valid_Search", dataProviderClass = dataProvider.DP_Search.class)
	public void validSearch(String TC_ID, String Order, String Search_Item, String expected)
	{
		/*driver.findElement(By.id("srchword")).sendKeys(Search_Item);
		driver.findElement(By.className("newsrchbtn")).click();
		String validsearch = driver.findElement(By.id("find")).getText();*/
		Pagefactory_HomePage home = new Pagefactory_HomePage(driver);
		home.Enter_SearchText(Search_Item);
		home.Click_Search_Button();
		String validsearch = home.get_valid_Search_msg();
		
		System.out.println(validsearch);
		SoftAssert asst = new SoftAssert();
		asst.assertEquals(validsearch, expected);
		asst.assertAll();
	}

}
