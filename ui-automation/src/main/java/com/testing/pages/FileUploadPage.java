package com.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    private String chooseFileInputXPath = "//input[@id='fileInput']";
    private String uploadButtonXPath = "//button[@id='fileSubmit']";
    private String uploadMessageXPath = "//div[@class='container']//h1";
    private String flashMessageXPath = "//div[@id='flash']//b";

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        driver.findElement(By.xpath(chooseFileInputXPath)).sendKeys(filePath);
    }

    public void clickUploadButton() {
    	WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(uploadButtonXPath))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadButton);
    }
    
    public String getFlashMessage() {
    	WebElement flashMessage = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(flashMessageXPath))));
        return flashMessage.getText();
    }

    public String getUploadConfirmation() {
    	WebElement uploadMessage = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(uploadMessageXPath))));
        return uploadMessage.getText();
    }
}
