package KiteAppTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClasses.*;
import kiteAppUsingPOMClasses.KiteLogInPage;
import kiteAppUsingPOMClasses.kitehomepage;
import kiteAppUsingPOMClasses.kitepinpage;
import UtilityPackage.Utility;


@Listeners(listenerPackage.ListenerClass.class)
public class KiteUserNameValidation extends BaseClasses.BaseClass{ 	
	
			
			KiteLogInPage login;
			kitepinpage pin;
			kitehomepage home;
			
			
			@BeforeClass 
			
			public void BrowserLaunch() 
			
			{   launchBrowser();
				login=new KiteLogInPage(driver);
				pin=new kitepinpage(driver);
				home=new kitehomepage(driver);
				
			}
			@BeforeMethod
			
			public void loginTokiteApp() throws EncryptedDocumentException, IOException
			
			{  
				login.enterUserID(UtilityPackage.Utility.readDataFromExcel(0, 0));
				login.enterPAssword(UtilityPackage.Utility.readDataFromExcel(0, 1));
				login.clickOnLoginButtton();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
				
				pin.sendPin(UtilityPackage.Utility.readDataFromExcel(0, 2));
				pin.clickOnContinueButton();
			}
			 
			
		  @Test
		  public void userNameValidation() throws EncryptedDocumentException, IOException 
		  
		  {
		    
		    
		    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		    
		    String actualUserID=home.validateUserID();
		    String expectedUserID=UtilityPackage.Utility.readDataFromExcel(0, 4);
		    Assert.assertEquals(expectedUserID, actualUserID,"Actual and Expected not matching");
		    //UtilityPackage.Utility.takeScreenshot(driver, 999);
		    Reporter.log("Validated UserName", true);
		    }
		    @AfterMethod
		    public void logoutFromKiteApp() throws InterruptedException
		    {
		    home.clickOnLogout();
		    Reporter.log("Logging out", true);
		    }
  
		    @AfterClass
		    public void   browserclosing()
		    {
		    	browserclose();
  
   }
}
