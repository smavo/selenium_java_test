package org.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public WebDriver initializeDriver(){

        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();
        //Maximize the browser
        driver.manage().window().maximize();
        return driver;

    }


}
