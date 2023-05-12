package com.actitime.Genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this is a generic library class which contains all the generic methods
 * @author ashish
 *
 */
public class File_library {
/**
 * This is a generic method which is used to read the data from property file
 * @return 
 * @throws IOException
 */
	public String readdatafrompropertyfile( String key) throws IOException {
		FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * This method is a generic method which is used to read the data from excel sheet
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname,int row ,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./Testdata/TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
	    String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	    return value;
	}	
	}
