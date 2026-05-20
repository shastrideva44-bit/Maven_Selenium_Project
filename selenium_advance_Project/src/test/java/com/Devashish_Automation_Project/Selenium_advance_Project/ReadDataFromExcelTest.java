package com.Devashish_Automation_Project.Selenium_advance_Project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// here i am doing MANUALLY getting the data from the excel file..HARD CODING
		
		
		//STEP 1: GET THE EXCEL PATH LOACATION nd java object of the physical excelfile
	FileInputStream fis = new FileInputStream("‪E:\\ECLIPSE\\TestsciptData.xlsx");	
	
	// Step 2: open workbook in read mode
	WorkbookFactory.create(fis);

	}

}
