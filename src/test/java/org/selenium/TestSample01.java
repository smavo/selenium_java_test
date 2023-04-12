package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSample01 {

    @Test
    public void dumyTest(){

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_112.0.5615.49.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();

        // Launch Website
        driver.get("https://askomdch.com/");

        //Maximize the browser
        driver.manage().window().maximize();

        driver.close();
        driver.quit();

    }

}