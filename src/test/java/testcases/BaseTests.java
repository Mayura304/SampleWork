package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentReportGen;
import pages.LogInPage;

public class BaseTests  {

	
	public static WebDriver driver;
	public LogInPage lp;
	
	@BeforeSuite
	public void beforeSuite() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notification");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String title = driver.getTitle();
		System.out.println(title);
		

	}
	
	@BeforeClass
	public void createObject() {
		
		lp = new LogInPage(driver);
	}
	
	
}
