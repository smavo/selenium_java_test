package org.selenium.pom.tests;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAdress02;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPom16 extends BaseTest {

    @Test(priority = 2)
    public void EndToEndTest_16() throws InterruptedException, IOException {
        String searchFor = "Blue";
        BillingAdress02 billingAdress02 = JacksonUtils.deserializeJson("MyData.json", BillingAdress02.class);
        Product product = new Product(1209);
        User user = new User("test170296@gmail.com", "1nd1.sm4rt%%");

        HomePage homePage = new HomePage(driver);
        homePage.load();
        StorePage storePage = homePage.clicStoreMenuLink();
        storePage.isLoaded();

        // Search
        // storePage.textInSearchField("Blue");
        storePage.textInSearchField(searchFor);
        storePage.clickSearchBtn();
        // storePage.searchTextPublic("Blue");  // Esta función reemplaza a las 2 primeras aplicando "functional page object"

        // storePage.getTitleResult("Search results: “Blue”");
        storePage.getTitleResult("Search results: “"+searchFor+"”");
        storePage.clickAddToCardButton(product.getName());

        CartPage cartPage = storePage.clickViewCart();
        cartPage.isLoaded();

        // Page Cart
        cartPage.getTitleResult(product.getName(), 3000);
        // CheckoutPage checkoutPage = cartPage.clickCheckoutButton(3000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton2();

        // Login
        // checkoutPage.login(user.getUsername(),user.getPassword(),1000);

        // Page Checkout
        checkoutPage.setBillingAdress02(billingAdress02)
                .ClickPaymentMethod(2000)
                //.ClickPlaceOrder(5000)
                .ClickPlaceOrder3()
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");
    }

}