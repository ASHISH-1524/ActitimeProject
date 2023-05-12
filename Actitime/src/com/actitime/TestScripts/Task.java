package com.actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.Genericlibrary.Baseclass;
import com.actitime.Genericlibrary.File_library;
import com.actitime.objectrepository.HomePage;
import com.actitime.objectrepository.TaskPage;

public class Task extends Baseclass {

	@Test
 public void customer() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();

		TaskPage tp =new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		
		File_library f = new File_library();
		String createcustomer = f.readDataFromExcel("Sheet1", 1, 1);
		tp.getCustname().sendKeys(createcustomer);
		String desc = f.readDataFromExcel("Sheet1", 1, 2);
        tp.getCustdesct().sendKeys(desc);
        tp.getCreatecust().click();
        String expectedresult = createcustomer;
        WebElement Actualresult = driver.findElement(By.xpath("(//div[.='"+createcustomer+"'])[2]"));
        
        SoftAssert s = new SoftAssert();
        s.assertEquals(Actualresult, expectedresult);
        s.assertAll();
	}
}
