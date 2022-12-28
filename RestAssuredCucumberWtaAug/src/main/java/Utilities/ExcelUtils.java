package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private Workbook wb;
	
	public ExcelUtils(String excelFileName) throws EncryptedDocumentException, IOException
	{
		if(wb == null)
		{
			InputStream is = ExcelUtils.class.getClassLoader()
					.getResourceAsStream("excelFiles/" + excelFileName);
			wb = WorkbookFactory.create(is);
		}
	}
	
	public LinkedHashMap<String,String> getExcelDataAsMap(String sheetName)
	{
		LinkedHashMap<String,String> dataAsMap = new LinkedHashMap<>();
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		for(int i = 0 ; i< rowCount ; i++)
		{
			Row row = sheet.getRow(i);
			String key = row.getCell(0).getStringCellValue();
			String value = row.getCell(1).getStringCellValue();
			dataAsMap.put(key, value);
		}
		return dataAsMap;
	}
	
	public Object[][] getDataForDataProvider(String sheetName)
	{
		DataFormatter formatter = new DataFormatter();
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows(); //4
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells(); //7
		
		Object[][] data = new Object[rowCount-1][cellCount];
		
		for(int i = 0 ; i<rowCount -1 ; i++)
		{
			Row r = sheet.getRow(i+1);
			for(int j = 0 ; j< cellCount ; j++)
			{
				String cellValue = formatter.formatCellValue(r.getCell(j));
				data[i][j] = cellValue;
				
			}
		}
		
		
		for(int i = 0; i<data.length ; i++)
		{
			for(int j = 0 ; j< data[i].length ; j++)
			{
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
