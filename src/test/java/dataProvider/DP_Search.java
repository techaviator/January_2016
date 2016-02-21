package dataProvider;

import generic.ExcelReader;
import generic.UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DP_Search {
	
	@DataProvider (name = "Invalid_Search")
	public static Iterator<Object[]> DP_InvalidSearch() throws Exception
	{
		List<Object[]> ls = getXLdata("Invalid_Search");
		return ls.iterator();
	}
	
	@DataProvider (name = "valid_Search")
	public static Iterator<Object[]> DP_validSearch() throws Exception
	{
		List<Object[]> ls = getXLdata("Valid_Search");
		return ls.iterator();
	}
	
	public static List<Object[]> getXLdata(String Scriptname) throws Exception
	{
		ExcelReader xl = new ExcelReader(UtilityClass.getPropertyfile("XLfile"));
		int rowcount = xl.getrowcount("Scenario_Search");
		List<Object[]> ls = new ArrayList<Object[]>();
		for(int i=1;i<=rowcount;i++)
		{
			if(xl.readcellvalue("Scenario_Search", i, 3).equalsIgnoreCase(Scriptname))
					{
				if(xl.readcellvalue("Scenario_Search", i, 2).equalsIgnoreCase("Y"))
						{
							Object[] obj = new Object[4];
							/*obj[0]= "Raje";
							obj[1]= "ghagh";
							obj[2]= "Sorry we were unable to complete this step because :";
							*/
							obj[0] = xl.readcellvalue("Scenario_Search", i, 0);
							obj[1] = xl.readcellvalue("Scenario_Search", i, 1);
							obj[2] = xl.readcellvalue("Scenario_Search", i, 4);
							obj[3] = xl.readcellvalue("Scenario_Search", i, 5);
							
							ls.add(obj);
						}
					}
	}
		return ls;
	}

}
