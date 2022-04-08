package kiteAppUsingPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogInPage {

	//1. variable declaration-->WebElement
	
		@FindBy(id ="userid") private WebElement UserID;
		@FindBy(id="password") private WebElement Password;
		@FindBy(xpath = "//button[@type='submit']") private WebElement LoginButton;
//		@FindBy(xpath = "//span[contains(text(),'User ID should be ')]") private WebElement UserIdErrorMsg;
		
		
		//2. use constructor-->public
		
		public KiteLogInPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//3.methods
		
		public void enterUserID(String uid)
		{
			UserID.sendKeys(uid);
			
		}
		
		public void enterPAssword(String pwd)
		{
			Password.sendKeys(pwd);
		}
		public void clickOnLoginButtton()
		{
			LoginButton.click();
		}
//		public String getUserIdErrorMsg()
//		{
//		String errorMsg = UserIdErrorMsg.getText();
//		return errorMsg;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

