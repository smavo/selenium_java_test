package org.selenium;
import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPom04 extends BaseTest {

    @Test
    public void demotest() throws InterruptedException{

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clicStoreMenuLink();

        // Search
        storePage.textInSearchField("Blue");
        storePage.clickSearchBtn();
        // storePage.searchTextPublic("Blue");  // Esta función reemplaza a las 2 primeras aplicando "functional page object"

        storePage.getTitleResult("Search results: “Blue”");
        storePage.clickAddToCardButton("Denim Blue Jeans");

        CartPage cartPage = storePage.clickViewCart();

        // Page Cart
        cartPage.getTitleResult("Denim Blue Jeans", 3000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton(3000);

        // Page Checkout
        checkoutPage.enterFirstName("Test")
                .enterLastName("Test")
                .enterCompanyName("Testing ORG")
                .SelectCountry("Peru")
                .enterAddress_1("San Luis - Lima")
                .enterAddress_2("Perú 2023")
                .clickCity("Ate Vitarte")
                .SelectState("Lima")
                .enterPostcodeField("15744")
                .enterPhoneField("978554490")
                .enterEmailField("test@gmail.com")
                .enterCommentsField("Orden de compra de prueba", 3000)
                .ClickPaymentMethod(3000)
                .ClickPlaceOrder(3000)
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");

        // Page Checkout
        /*
        driver.findElement(By.id("billing_first_name")).sendKeys("Test");
        driver.findElement(By.id("billing_last_name")).sendKeys("Test");
        driver.findElement(By.id("billing_company")).sendKeys("Testing ORG");
        driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
        driver.findElement(By.xpath("//span/ul/li[contains(.,'Peru')]")).click();
        driver.findElement(By.id("billing_address_1")).sendKeys("Ate Vitarte - Lima");
        driver.findElement(By.id("billing_address_2")).sendKeys("Perú 2023");
        driver.findElement(By.id("billing_city")).sendKeys("Lima");
        driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
        driver.findElement(By.xpath("//ul/li[@class='select2-results__option'][contains(.,'Lima')]")).click();
        driver.findElement(By.id("billing_postcode")).sendKeys("15744");
        driver.findElement(By.id("billing_phone")).sendKeys("978554490");
        driver.findElement(By.id("billing_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("order_comments")).sendKeys("Orden de compra de prueba");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='payment_method_cod']")).click();
        Thread.sleep(3000);

        // Page Checkout Details
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(.,'Checkout')]")).getText(),
                "Checkout"
        );

        */
        // driver.quit();

    }

}