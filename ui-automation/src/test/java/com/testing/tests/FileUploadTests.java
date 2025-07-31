package com.testing.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.testing.pages.FileUploadPage;
import com.testing.utils.DriverFactory;

public class FileUploadTests {
	private WebDriver driver;
	private FileUploadPage fileUploadPage;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		fileUploadPage = new FileUploadPage(driver);
	}

	@Test(description = "TC08: Upload a valid file under 500 KB")
	public void testFileUpload() {
		String filePath = System.getProperty("user.dir") + "/src/test/testdata/FileLessThan500KB.txt";
		fileUploadPage.uploadFile(filePath);
		fileUploadPage.clickUploadButton();

		String confirmation = fileUploadPage.getUploadConfirmation();
		Assert.assertEquals(confirmation, "File Uploaded!");
	}

	@Test(description = "TC09: Attempt to upload a file greater than 500 KB")
	public void testInvlidFileUpload() {
		String filePath = System.getProperty("user.dir") + "/src/test/testdata/FileGreaterThan500KB.jpg";
		fileUploadPage.uploadFile(filePath);
		fileUploadPage.clickUploadButton();

		String confirmation = fileUploadPage.getFlashMessage();
		Assert.assertEquals(confirmation, "File too large, please select a file less than 500KB");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
