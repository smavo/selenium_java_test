package org.selenium;
import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class TestPom05 extends BaseTest {

    @Test
    public void demotest() throws InterruptedException{

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clicStoreMenuLink();

        // Search
        storePage.textInSearchField("Blue");
        storePage.clickSearchBtn();
        // storePage.searchTextPublic("Blue");  // Esta función reemplaza a las 2 primeras aplicando "functional page object"

        storePage.getTitleResult("Search results: “Blue”");
        storePage.clickAddToCardButton("Faint Blue Jeans");

        CartPage cartPage = storePage.clickViewCart();

        // Page Cart
        cartPage.getTitleResult("Faint Blue Jeans", 3000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton(3000);

        // Login
        checkoutPage.login("test170296@gmail.com","1nd1.sm4rt%%",1000);

        /*
        // Click here to login
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/div[@class='woocommerce-info']/a[contains(.,'Click here to login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form/p/input[@name='username']")).sendKeys("test170296@gmail.com");
        driver.findElement(By.xpath("//p/span/input[@id='password']")).sendKeys("1nd1.sm4rt%%");
        driver.findElement(By.xpath("//input[contains(@id,'rememberme')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        */

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
                .enterCommentsField("Orden de compra de prueba")
                .ClickPaymentMethod(2000)
                .ClickPlaceOrder(3000)
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");
    }

}