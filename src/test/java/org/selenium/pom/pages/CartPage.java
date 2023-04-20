package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

public class CartPage extends BasePage {

    private final By titleResult =  By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]");
    public CartPage(WebDriver driver){
        super(driver);
    }

    public void getTitleResult(String textoCompare, Integer tiempo) throws InterruptedException{
        driver.findElement(titleResult).getText();

        Assert.assertEquals(
                driver.findElement(titleResult).getText(),textoCompare
        );
        Thread.sleep(tiempo);
    }

    public CheckoutPage clickCheckoutButton(Integer tiempo) throws InterruptedException{
        driver.findElement(checkoutButton).click();
        Thread.sleep(tiempo);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickCheckoutButton2(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        // driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }

}
