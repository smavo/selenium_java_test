package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

import java.time.Duration;

public class DriverManager {

    // Utilizando WebDriverManager
    public WebDriver initializeDriver(){
        // Google
        /* WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriver driver = new ChromeDriver(); */

        // Firefox
        /* WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        WebDriver driver = new FirefoxDriver(); */

        // Edge
        /* WebDriverManager.edgedriver().cachePath("Drivers").setup();
        WebDriver driver = new EdgeDriver(); */


        WebDriver driver;
        String Browser = System.getProperty("browser", "CHROME");
        switch (DriverType.valueOf(Browser)){
            case CHROME -> {
            // case "Chrome" -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                driver = new EdgeDriver();
            }
            default -> throw new IllegalMonitorStateException("Invalid browser name:" + Browser);
        }

        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Usando Espera implicit
        return driver;

    }

    // Utilizando WebDriver
    public WebDriver initializeDriver2(){

        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();
        //Maximize the browser
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Usando Espera implicit
        return driver;

    }


}
