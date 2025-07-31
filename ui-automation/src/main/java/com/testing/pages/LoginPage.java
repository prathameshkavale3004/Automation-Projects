package com.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    private String emailXPath = "//input[@id='username']";
    private String passwordXPath = "//input[@id='password']";
    private String loginButtonXPath = "//button[contains(text(), 'Login')]";
    private String flashMessageXPath = "//div[@id='flash']//b";
    private String logoutButtonXPath = "//i[contains(text(), 'Logout')]/..";
   
    
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(By.xpath(emailXPath)).sendKeys(user);
        driver.findElement(By.xpath(passwordXPath)).sendKeys(pass);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(loginButtonXPath))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }

    public String getFlashMessage() {
    	WebElement flashMessage = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(flashMessageXPath))));
        return flashMessage.getText();
    }
    
    public void logout() {
    	WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(logoutButtonXPath))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);
    }

    
}

