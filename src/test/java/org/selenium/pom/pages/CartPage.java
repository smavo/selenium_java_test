package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

public class CartPage extends BasePage {

    private final By titleResult =  By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]");
    private final By cartHeading = By.cssSelector(".has-text-align-center");

    @FindBy(css = "td[class='product-name'] a") private WebElement titleResults;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'checkout-button button alt wc-forward')]") @CacheLookup private WebElement checkoutButtons;
    // @CacheLookup --> Solo usarlo cuando se tienen cargar de data que no varía es decir que no es dinámica,
    // ya que esta podría causar un fallo si se usa en pruebas donde la data es dinámica

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean isLoaded(){
        return wait.until(ExpectedConditions.textToBe(cartHeading, "Cart"));
    }

    public String getTitleResult(String textoCompare){
        return wait.until(ExpectedConditions.visibilityOf(titleResults)).getText();

    }

    public void getTitleResult(String textoCompare, Integer tiempo) throws InterruptedException{
        driver.findElement(titleResult).getText();
        Assert.assertEquals(
                driver.findElement(titleResult).getText(),textoCompare
        );
        Thread.sleep(tiempo);
    }

    public void getTitleResult2(String textoCompare){
        // driver.findElement(titleResult).getText();
        wait.until(ExpectedConditions.visibilityOf(titleResults)).getText();

        Assert.assertEquals(
                //driver.findElement(titleResults).getText(),textoCompare
                wait.until(ExpectedConditions.visibilityOf(titleResults)).getText(), textoCompare
        );

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

    public CheckoutPage clickCheckoutButton3(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtons)).click();
        return new CheckoutPage(driver);
    }

}
