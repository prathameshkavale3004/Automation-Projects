package com.testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        return new EdgeDriver();
    }
}