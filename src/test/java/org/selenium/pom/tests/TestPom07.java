package org.selenium.pom.tests;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAdress02;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class TestPom07 extends BaseTest {

    // @Test   // --> Test con problemas no ejecutar
    public void EndToEndTest_07() throws InterruptedException{
        BillingAdress02 billingAdress02 = new BillingAdress02()
        .setFirstnamess("Test 01")
        .setLastnamess("Sample 02")
        .setCompanyss("Testing Hands 2023")
        .setAddres01ss("SAN FRANCISCO")
        .setAddres02ss("CALIFORNIA")
        .setCityss("PALO ALTO")
        .setPostcodess("14555")
        .setPhoness("0123545698")
        .setEmailss("test@gmail.com")
        .setCommentsss("Orden de compra test 01");

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

        // Page Checkout
        checkoutPage.setBillingAdress02(billingAdress02)
                .ClickPaymentMethod(2000)
                .ClickPlaceOrder(5000)
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");
    }

}