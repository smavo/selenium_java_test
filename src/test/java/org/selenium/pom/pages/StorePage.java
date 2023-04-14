package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

public class StorePage extends BasePage {

    private final By searchField = By.xpath("//input[@class='search-field']");
    private final By searchButton = By.xpath("//button[@value='Search']");
    private final By title = By.xpath("//h1[contains(@class,'woocommerce-products-header__title page-title')]");
    private final By addToCard = By.xpath("//a[@href='?add-to-cart=1215'][contains(.,'Add to cart')]");
    private final By viewCart = By.xpath("//a[@title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    // Page Object Model ---> modelo de objeto de página
    public void textInSearchField(String texto){
        driver.findElement(searchField).sendKeys(texto);
    }

    public void clickSearchBtn(){
        driver.findElement(searchButton).click();
    }

    public void getTitleResult(String textoCompare){
        driver.findElement(title).getText();

        Assert.assertEquals(
                driver.findElement(title).getText(),textoCompare
        );

    }

    // POM - Usando Variables clickAddToCard
    public void clickAddToCardButton(String productName) throws InterruptedException{
        By addToCardButton = By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
        driver.findElement(addToCardButton).click();
        Thread.sleep(3000);
    }

    // functional page object ---> objeto de página funcional
    public void searchTextPublic(String texto){
        driver.findElement(searchField).sendKeys(texto);
        driver.findElement(searchButton).click();
    }

    // POM - Sin usar Variables clickAddToCard
    public void clickAddToCard() throws InterruptedException{
        driver.findElement(addToCard).click();
        Thread.sleep(3000);
    }

    // Page CartPage
    public CartPage clickViewCart(){
        driver.findElement(viewCart).click();
        return new CartPage(driver);
    }


}
