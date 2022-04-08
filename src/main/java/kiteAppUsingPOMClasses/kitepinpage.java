package kiteAppUsingPOMClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kitepinpage {
	    //1.
		@FindBy(id = "pin") private WebElement pin;
		@FindBy(xpath = "//button[@type='submit']") private WebElement continueButton;
		
		//2.
		public kitepinpage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//3.
		
		public void sendPin(String PIN)
		{
			pin.sendKeys(PIN);
		}
		
		public void clickOnContinueButton()
		{
			continueButton.click();
		}

}
