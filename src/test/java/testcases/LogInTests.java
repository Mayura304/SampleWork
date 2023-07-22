package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.TestNGListeners;
import utility.ReadDataFromPropFile;

public class LogInTests extends TestNGListeners {
	
	@Test(priority=1)
	public void validateLogIn() throws IOException {
		
		test.info("Enter credential");
		lp.logIn(ReadDataFromPropFile.readConfigData("username"),ReadDataFromPropFile.readConfigData("password"));
		test.info("Credential gets entered");
	}
	
	@Test(priority=2)
	public void validateTitle() {
		
		test.info("Verify webpage title");
		String actualtitle = lp.titleOfPage();
		String expectedtitle1 = "OrangeHRM";
		Assert.assertEquals(actualtitle, expectedtitle1);
		test.info("Webpage title verified");
		
		
	}

}
