package org.selenium.pom.tests;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAdress01;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.annotations.Test;

public class TestPom06 extends BaseTest {

    // @Test
    public void EndToEndTest_06() throws InterruptedException{
        BillingAdress01 billingAdress01 = new BillingAdress01();
        billingAdress01.setFirstname("Test 01");
        billingAdress01.setLastname("Sample 02");
        billingAdress01.setCompany("Testing Hands 2023");
        billingAdress01.setAddres01("SAN FRANCISCO");
        billingAdress01.setAddres02("CALIFORNIA");
        billingAdress01.setCity("PALO ALTO");
        billingAdress01.setPostcode("14555");
        billingAdress01.setPhone("0123545698");
        billingAdress01.setEmail("test@gmail.com");
        billingAdress01.setComments("Orden de compra test 01");

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
        // checkoutPage.login("test170296@gmail.com","1nd1.sm4rt%%",1000);

        // Page Checkout
        checkoutPage.setBillingAdress01(billingAdress01)
                /* .enterFirstName("Test")
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
                .enterCommentsField("Orden de compra de prueba") */
                .ClickPaymentMethod(2000)
                .ClickPlaceOrder(5000)
                .getTitleCheckoutValid("Checkout", "Thank you. Your order has been received.");
    }

}