package com.testing.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.testing.pages.LoginPage;
import com.testing.utils.DriverFactory;

public class LoginTests {
	WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		loginpage = new LoginPage(driver);
	}

	@Test(description = "TC02: Verify logout after successful login and validate display messages")
	public void testValidLogin() {
		loginpage.login("practice", "SuperSecretPassword!");
		Assert.assertEquals(loginpage.getFlashMessage(), "You logged into a secure area!");
		loginpage.logout();
		Assert.assertEquals(loginpage.getFlashMessage(), "You logged out of the secure area!");
	}

	@Test(description = "TC03: Login with invalid username")
	public void testInvalidUsernameLogin() {
		loginpage.login("wrong", "SuperSecretPassword!");
		Assert.assertEquals(loginpage.getFlashMessage(), "Your username is invalid!");

	}

	@Test(description = "TC04: Login with invalid password")
	public void testInvalidPasswordLogin() {
		loginpage.login("practice", "wrong");
		Assert.assertEquals(loginpage.getFlashMessage(), "Your password is invalid!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
