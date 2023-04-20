package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(){

        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();
        //Maximize the browser
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Usando Espera implicit
        return driver;

    }


}
