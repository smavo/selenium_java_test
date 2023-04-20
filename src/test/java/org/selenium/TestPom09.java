package org.selenium;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAdress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class TestPom09 extends BaseTest {

    @Test
    public void EndToEndTest() throws InterruptedException{

        BillingAdress billingAdress = new BillingAdress("Test 001", "Sample 01 test",
                "Testing HANDS 2023", "SAN FRANCISCO", "CALIFORNIA", "PALO ALTO",
                "14558", "978554477", "test@gmail.com", "Orden de compra de Prueba");

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clicStoreMenuLink();

        // Search
        storePage.textInSearchField("Blue");
        storePage.clickSearchBtn();
        // storePage.searchTextPublic("Blue");  // Esta función reemplaza a las 2 primeras aplicando "functional page object"

        storePage.getTitleResult("Search results: “Blue”");
        storePage.clickAddToCardButton("Blue Denim Shorts");

        CartPage cartPage = storePage.clickViewCart();

        // Page Cart
        cartPage.getTitleResult("Blue Denim Shorts", 3000);
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton(3000);

        // Login
        checkoutPage.login("test170296@gmail.com","1nd1.sm4rt%%",1000);

        // Page Checkout
        checkoutPage.setBillingAdress(billingAdress)
                .ClickPaymentMethod(2000)
                .ClickPlaceOrder(5000)
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");
    }

}