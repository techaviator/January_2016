package dataProvider;

import generic.ExcelReader;
import generic.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DP_Login {
	
	@DataProvider(name = "Invalid_Login")
	public static Iterator<Object[]> Invalid_DP() throws Exception
	{
		/*List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[3];
		obj[0]= "Raje";
		obj[1]= "ghagh";
		obj[2]= "Sorry we were unable to complete this step because :";
		ls.add(obj);*/
		
		 List<Object[]> ls = getXLdata("Invalid_Login_test");
		 
		return ls.iterator();
	}
	
	@DataProvider(name = "valid_Login")
	public static Iterator<Object[]> valid_DP() throws Exception
	{
		/*List<Object[]> ls = new ArrayList<Object[]>();
		Object[] obj = new Object[3];
		obj[0]= "Raje";
		obj[1]= "ghagh";
		obj[2]= "Sorry we were unable to complete this step because :";
		ls.add(obj);*/
		
		List<Object[]> ls = getXLdata("Valid_Login_test");
		return ls.iterator();
	}
	
	public static List<Object[]> getXLdata(String Scriptname) throws Exception
	{
		ExcelReader xl = new ExcelReader(UtilityClass.getPropertyfile("XLfile"));
		int rowcount = xl.getrowcount("Scenario_Login");
		List<Object[]> ls = new ArrayList<Object[]>();
		for(int i=1;i<=rowcount;i++)
		{
			if(xl.readcellvalue("Scenario_Login", i, 3).equalsIgnoreCase(Scriptname))
					{
				if(xl.readcellvalue("Scenario_Login", i, 2).equalsIgnoreCase("Y"))
						{
							Object[] obj = new Object[5];
							/*obj[0]= "Raje";
							obj[1]= "ghagh";
							obj[2]= "Sorry we were unable to complete this step because :";
							*/
							obj[0] = xl.readcellvalue("Scenario_Login", i, 0);
							obj[1] = xl.readcellvalue("Scenario_Login", i, 1);
							obj[2] = xl.readcellvalue("Scenario_Login", i, 4);
							obj[3] = xl.readcellvalue("Scenario_Login", i, 5);
							obj[4] = xl.readcellvalue("Scenario_Login", i, 6);
							ls.add(obj);
						}
					}
	}
		return ls;
	}

}
