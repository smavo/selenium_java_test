package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.xpath("(//li/a[contains(.,'Store')])[1]");
    public HomePage(WebDriver driver){
        super(driver);
    }

    public StorePage clicStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

}
