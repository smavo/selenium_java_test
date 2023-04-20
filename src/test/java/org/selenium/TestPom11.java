package org.selenium;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAdress02;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPom11 extends BaseTest {

    @Test
    public void EndToEndTest() throws InterruptedException, IOException {
        BillingAdress02 billingAdress02 = JacksonUtils.deserializeJson("MyData.json", BillingAdress02.class);
        Product product = new Product(1205);

        /* BillingAdress02 billingAdress02 = new BillingAdress02();
        InputStream filepath = getClass().getClassLoader().getResourceAsStream("MyData.json");
        billingAdress02 = JacksonUtils.deserializeJson(filepath, billingAdress02); */

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clicStoreMenuLink();

        // Search
        storePage.textInSearchField("Blue");
        storePage.clickSearchBtn();
        // storePage.searchTextPublic("Blue");  // Esta función reemplaza a las 2 primeras aplicando "functional page object"

        storePage.getTitleResult("Search results: “Blue”");
        // storePage.clickAddToCardButton("Faint Blue Jeans");
        storePage.clickAddToCardButton(product.getName());

        CartPage cartPage = storePage.clickViewCart();

        // Page Cart
        // cartPage.getTitleResult("Faint Blue Jeans", 3000);
        cartPage.getTitleResult(product.getName(), 3000);
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