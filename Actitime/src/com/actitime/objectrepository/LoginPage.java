package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
		@FindBy(id = "username")
		private WebElement untb;
		
		@FindBy(name = "pwd")
		private WebElement pwtb;
		
		@FindBy(xpath = "//div[.='Login ']")
		private WebElement lgbtn;
		
		//initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
	
		public WebElement getUntb() {
			return untb;
		}

		public WebElement getPwtb() {
			return pwtb;
		}

		public WebElement getLgbtn() {
			return lgbtn;
		}
}
