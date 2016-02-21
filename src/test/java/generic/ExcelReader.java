package generic;

import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*When working with selenium projects , the coder will have to interact with
 * excel to read/write data from it. The ExcelReader class could be used to retrive
 * data in string format as anything passed into application using selenium is of
 * type string . THere are six methods in the class any user will have to 
 * follow the below structure when using this class
 * > Call the Excel Reader contructor to interact with the excel
 * > CAll getrowcount method to get row count
 * > call getcolumncount method to get col count
 * > Call readcellvalue/writecellvalue to read/ write data from/to excel cell
 * > Call saveexcel with the user write value to the excel.
 
 */

public class ExcelReader {
	XSSFWorkbook wb=null; //making workbook variable global to use it throughout all methods in the class
	public ExcelReader(String path) throws Exception
	{
		/*
		 * The contructor would call excel specified in the path variable
		 * and using FileInputStream to load data as a stream of bytes from excel to workbook wb
		 * 
		 */
		FileInputStream fis =new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 if(wb!=null)
		 {
			System.out.println("Connection Success"); 
		 }
		 else
			 System.out.println("Connection failed");
		fis.close();
	}
	
	
	public XSSFSheet setsheet(String sheetname)
	{
		/*
		 * This method is created because to interact with a cell in an
		 * excel, the user should always specify Sheetname,the row and then the column
		 * The below methods will have to follow the same structure and to avoid 
		 * code redundacy for sheet name the setsheet method is used. Any
		 * method which calls this method gets the XSSFSheet value as return type.
		 */
		XSSFSheet sheet = wb.getSheet(sheetname);
		return sheet;
	}
	
	public int getrowcount(String sheetname)
	{
		/* 
		 * to get the number of row counts which helps in reading
		 *  all rows in the column
		 */
		XSSFSheet sheet = setsheet( sheetname);//look the comments for setsheet method
		//XSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
		
	}
	
	public int getcolumncount(String sheetname, int rowindex)
	{
		/*
		 * method used to get column count which helps to traverse through all columns
		 */
		XSSFSheet sheet = setsheet( sheetname);
		//XSSFSheet sheet = wb.getSheet(sheetname);
		int colcount = sheet.getRow(rowindex).getLastCellNum();
		return colcount;
	}
	
	
	
	public String readcellvalue(String sheetname,int rowindex, int colindex)
	{
		/*
		 * This method is used to read a cell value from excel. If the user 
		 * need to read the value from a cell eg: (1,1). THen he will have to
		 * specify the sheetname , then the rowindex  and finally the column index
		 * as parameters to the readcellvalue method. THe data read from the excel
		 * is in various datatypes , eg: string , number, blank... WE capture value
		 * with various datatype and convert it into String , so that the string value
		 * could be passed to the selenium code
		 */
		String celltext=null;
		XSSFSheet sheet = setsheet( sheetname);
		//XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFCell cell = sheet.getRow(rowindex).getCell(colindex);//the statement to get value from a cell
		// the value in cell cannot be read by normal user , the following methods of XSSFCell will help in display 
		//the value of the cell in user friendly manner
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)// THis condition statement is used to find the datatype of the value in cell
		{
			 celltext = cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			celltext= String.valueOf(cell.getNumericCellValue());//converting the numeric value of cell to string for selenium code
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		{
			celltext="";
		}
		return celltext;
	}
	
	public void writecellvalue(String sheetname, int rowindex, int colindex, String value)
	{
		
		
		XSSFSheet sheet = setsheet( sheetname);
		//XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow row = sheet.getRow(rowindex);//code is to check if the rowindex exist in Work book
		XSSFCell cell = null;
		if (row==null)//if row doesnt exist in workbook
		{
			row=sheet.createRow(rowindex);//then create rowindex in the wb
		}
		else
		{
			 cell = sheet.getRow(rowindex).getCell(colindex);// if both rowindex and colindex exist in wb, then this statement will get value from the cell
		}
		
		if(cell==null)// if the col index is not available in workbook
		{
			 cell = sheet.getRow(rowindex).createCell(colindex);//this code with create a cell in specified (rowindex,colindex)
			
		}
			
		cell.setCellValue(value);// if both rowindex and colindex exist , data is written into the cell in the workbook
	}
	
	public void saveexcel(String path) throws Exception
	{
		/*
		 * when writing code , the code is saved in the workbook object of java and wont be
		 * save into excel unless we export it using FileOutputStream and write it in the excel
		 * The below code does the same.
		 */
		FileOutputStream fout = new FileOutputStream(path);
		wb.write(fout);
		fout.close();
	}
	
	
	
	

}
