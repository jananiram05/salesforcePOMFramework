package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.home.HomePage;
import com.pages.login.LoginPage;
import com.utility.PropertiesUtility;

@Listeners(com.utility.TestEventListnersutility.class)
public class SalesforceTestAutomation extends BaseTest {

	

	@Test
	@Parameters("browserName")
	public static void salesforceLoginErrorTc1() throws InterruptedException {
		String expected = "Please enter your password.";


		logger.info("Inside saesforce error login");
		extentreport.logTestInfo("Inside saesforce error login");

		// extentreport.logTestInfo("Inside saesforce error login");
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username = propertiesUtility.getPropertyValue("login.valid.userid");
		String password = propertiesUtility.getPropertyValue("login.empty.password");


		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseName(username);
		loginpage.enterpassWord(password);
	    driver=loginpage.clickLogin();
		String actual = loginpage.error();

		Assert.assertEquals(actual, expected);
		extentreport.logTestInfo("Inside saesforce error login method ended");

	}

	@Test
	@Parameters("browserName")
	public static void salesforceLoginTc2() {
		String expected = "Home Page ~ Salesforce - Developer Edition";

		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username = propertiesUtility.getPropertyValue("login.valid.userid");
		String password = propertiesUtility.getPropertyValue("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseName(username);
		loginpage.enterpassWord(password);
		driver = loginpage.clickLogin();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);


	

	}

	

	@Test
	@Parameters("browserName")
	public static void rememberMeTc3() {
		String expected = "Home Page ~ Salesforce - Developer Edition";


		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username = propertiesUtility.getPropertyValue("login.valid.userid");
		String password = propertiesUtility.getPropertyValue("login.valid.password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseName(username);
		loginpage.enterpassWord(password);
		loginpage.clickRemember();
		driver = loginpage.clickLogin();
		HomePage homePage=new HomePage(driver);
		homePage.logout();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);

		homePage.logout();
		
		}

	@Test
	@Parameters("browserName")
	public static void forgotPasswordTc4a() throws InterruptedException {
		String expected = "Login | Salesforce";
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username = propertiesUtility.getPropertyValue("login.invalid.userid");
		String password = propertiesUtility.getPropertyValue("login.invalid.password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseName(username);
		loginpage.enterpassWord(password);
		loginpage.clickRemember();
		driver = loginpage.clickLogin();
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);

	}

	@Test
	@Parameters("browserName")
	public static void forgotPasswordTc4() throws InterruptedException {
		String expected = "Forgot Your Password | Salesforce";

		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("applicationDataProperties");
		String username = propertiesUtility.getPropertyValue("login.valid.userid");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUseName(username);
		loginpage.forgotPassword();
		loginpage.clickContinue();
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);

	
		

		extentreport.logTestInfo("forgot password testcase ended");

	}

}