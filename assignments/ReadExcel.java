package week5.day2.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String filename) throws IOException
	{
		String filen=filename;
		//Get the Excel
		XSSFWorkbook wb=new XSSFWorkbook("./Data/"+filen+".xlsx");
		
		//Get the Sheet inside the Excel
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		//Get the row count
		int rowscount=ws.getLastRowNum();
		int col=ws.getRow(0).getLastCellNum();
		System.out.println(rowscount+" "+col);
		//Array to store the read data
		String[][] data=new String[rowscount][col];
		
		//Traverse through the rows
		for(int i=1;i<=rowscount;i++)
		{
			int colcount=ws.getRow(i).getLastCellNum();
			for(int j=0;j<colcount;j++)
			{
			String coldata=ws.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=coldata;
			}
		}

		wb.close();
		return data;
		
	}
	
}
