package com.actitime.Genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectrepository.HomePage;
import com.actitime.objectrepository.LoginPage;

public class Baseclass {
public static WebDriver driver;
 File_library f = new File_library();
 
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchthebrowser() throws IOException {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readdatafrompropertyfile("url");
		driver.get(URL);
		Reporter.log("browser is launch",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String UN = f.readdatafrompropertyfile("username");
			lp.getUntb().sendKeys("admin");
		String PW = f.readdatafrompropertyfile("password");
			lp.getPwtb().sendKeys("manager");
			lp.getLgbtn().click();
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLgot().click();
		Reporter.log("logged out successfully",true);
	}
	@AfterClass
	public void closethebrowser() {
		driver.close();
		Reporter.log("browser is close",true);
	}
	@AfterSuite
	public void closethedabaseconnection() {
		Reporter.log("database is disconnected",true);

	}
}
