package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@name='username']") WebElement adminusername;
	@FindBy(xpath="//*[@name='password']") WebElement adminpassword;
	@FindBy(xpath="//*[@type='submit']") WebElement submit;
	
	public LogInPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String username, String password) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		adminusername.sendKeys(username);
		adminpassword.sendKeys(password);
		submit.click();
	}
	
	public String titleOfPage() {
		String title = driver.getTitle();
		return title;
	}



}
