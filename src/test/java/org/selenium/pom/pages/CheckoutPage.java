package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAdress;
import org.selenium.pom.objects.BillingAdress01;
import org.selenium.pom.objects.BillingAdress02;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By firstNameField =  By.id("billing_first_name");
    private final By lastNameField =  By.id("billing_last_name");
    private final By CompanyNameField =  By.id("billing_company");
    private final By countrySelector =  By.xpath("//span[@id='select2-billing_country-container']");
    private final By address_1 =  By.id("billing_address_1");
    private final By address_2 =  By.id("billing_address_2");
    private final By cityField = By.id("billing_city");
    private final By stateSelector = By.xpath("//span[@id='select2-billing_state-container']");
    private final By enterPostcode = By.id("billing_postcode");
    private final By enterPhone = By.id("billing_phone");
    private final By enterEmail = By.id("billing_email");
    private final By enterComments =  By.id("order_comments");
    private final By paymentMethod = By.xpath("//input[@id='payment_method_cod']"); // //input[@id='payment_method_bacs']
    private final By placeOrderButton = By.id("place_order");
    private final By checkoutOrderTitle = By.xpath("//h1[contains(.,'Checkout')]");
    private final By checkoutOrderText = By.xpath("//p[contains(.,'Thank you. Your order has been received.')]");
    private final By hereToLoginClick = By.xpath("//div/div[@class='woocommerce-info']/a[contains(.,'Click here to login')]");
    private final By enterUsernameField = By.xpath("//form/p/input[@name='username']");
    private final By enterPasswordField = By.xpath("//p/span/input[@id='password']");
    private final By rememberClick = By.xpath("//input[contains(@id,'rememberme')]");
    private final By buttonLoginClick = By.xpath("//button[@name='login']");

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstname){
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstname);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterCompanyName(String companyName){
        driver.findElement(CompanyNameField).clear();
        driver.findElement(CompanyNameField).sendKeys(companyName);
        return this;
    }

    public CheckoutPage SelectCountry(String country){
        By SelectCountry =  By.xpath("//span/ul/li[contains(.,'"+country+"')]");
        driver.findElement(countrySelector).click();
        driver.findElement(SelectCountry).click();
        return this;
    }

    public CheckoutPage enterAddress_1(String Address1){
        driver.findElement(address_1).clear();
        driver.findElement(address_1).sendKeys(Address1);
        return this;
    }

    public CheckoutPage enterAddress_2(String Address2){
        driver.findElement(address_2).clear();
        driver.findElement(address_2).sendKeys(Address2);
        return this;
    }

    public CheckoutPage clickCity(String city){
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckoutPage SelectState(String state){
        By SelectState = By.xpath("//ul/li[@class='select2-results__option'][contains(.,'"+state+"')]");
        driver.findElement(stateSelector).click();
        driver.findElement(SelectState).click();
        return this;
    }

    public CheckoutPage enterPostcodeField(String postcode){
        driver.findElement(enterPostcode).clear();
        driver.findElement(enterPostcode).sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterPhoneField(String phone){
        driver.findElement(enterPhone).clear();
        driver.findElement(enterPhone).sendKeys(phone);
        return this;
    }

    public CheckoutPage enterEmailField(String email){
        driver.findElement(enterEmail).clear();
        driver.findElement(enterEmail).sendKeys(email);
        return this;
    }

    public CheckoutPage enterCommentsField(String comments) {
        driver.findElement(enterComments).clear();
        driver.findElement(enterComments).sendKeys(comments);
        return this;
    }

    public CheckoutPage ClickPaymentMethod(Integer tiempo) throws InterruptedException{
        Thread.sleep(tiempo);
        driver.findElement(paymentMethod).click() ;
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage ClickPlaceOrder2(){
        // Thread.sleep(tiempo);
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Iniciando Validador de Overlay y su tamaño es: " + overlays.size());
        if(overlays.size() > 0){
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("El Overlay se pone invisible");
        }
        driver.findElement(placeOrderButton).click() ;
        // Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage ClickPlaceOrder3(){
        waitForOverlayToDisappear(overlay);
        driver.findElement(placeOrderButton).click() ;
        // Thread.sleep(tiempo);
        return this;
    }

   public CheckoutPage ClickPlaceOrder(Integer tiempo) throws InterruptedException{
        Thread.sleep(tiempo);
        driver.findElement(placeOrderButton).click() ;
        Thread.sleep(tiempo);
        return this;
    }

    public void getTitleCheckoutValid(String txtTitle, String txtSubTitle) {
        driver.findElement(checkoutOrderTitle).getText();
        driver.findElement(checkoutOrderText).getText();
        Assert.assertEquals(
                driver.findElement(checkoutOrderTitle).getText(),txtTitle
        );
        Assert.assertEquals(
                driver.findElement(checkoutOrderText).getText(),txtSubTitle
        );

    }

    public CheckoutPage clickHereToLoginLink(Integer tiempo) throws InterruptedException{
        Thread.sleep(tiempo);
        driver.findElement(hereToLoginClick).click();
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage enterUsername(String username){
        driver.findElement(enterUsernameField).clear();
        driver.findElement(enterUsernameField).sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword( String password){
        driver.findElement(enterPasswordField).clear();
        driver.findElement(enterPasswordField).sendKeys(password);
        return this;
    }

    public CheckoutPage clickRememberButton(Integer tiempo) throws InterruptedException {
        driver.findElement(rememberClick).click();
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage clickButtonLogin(Integer tiempo) throws InterruptedException {
        driver.findElement(buttonLoginClick).click();
        Thread.sleep(tiempo);
        return this;
    }

    public CheckoutPage login(String username, String password, Integer tiempo) throws InterruptedException{
        return clickHereToLoginLink(tiempo)
                .enterUsername(username)
                .enterPassword(password)
                .clickRememberButton(tiempo).clickButtonLogin(tiempo);
    }

    public CheckoutPage setBillingAdress01 (BillingAdress01 billingAdress01){
        return enterFirstName(billingAdress01.getFirstname())
                .enterLastName(billingAdress01.getLastname())
                .enterCompanyName(billingAdress01.getCompany())
                .enterAddress_1(billingAdress01.getAddres01())
                .enterAddress_2(billingAdress01.getAddres02())
                .clickCity(billingAdress01.getCity())
                .enterPostcodeField(billingAdress01.getPostcode())
                .enterPhoneField(billingAdress01.getPhone())
                .enterEmailField(billingAdress01.getEmail())
                .enterCommentsField(billingAdress01.getComments());
    }

    public CheckoutPage setBillingAdress02 (BillingAdress02 billingAdress02){
        return enterFirstName(billingAdress02.getFirstnamess())
                .enterLastName(billingAdress02.getLastnamess())
                .enterCompanyName(billingAdress02.getCompanyss())
                .enterAddress_1(billingAdress02.getAddres01ss())
                .enterAddress_2(billingAdress02.getAddres02ss())
                .clickCity(billingAdress02.getCityss())
                .enterPostcodeField(billingAdress02.getPostcodess())
                .enterPhoneField(billingAdress02.getPhoness())
                .enterEmailField(billingAdress02.getEmailss())
                .enterCommentsField(billingAdress02.getCommentsss());
    }
    public CheckoutPage setBillingAdress (BillingAdress billingAdress){
        return enterFirstName(billingAdress.getFirstnames())
                .enterLastName(billingAdress.getLastnames())
                .enterCompanyName(billingAdress.getCompanys())
                .enterAddress_1(billingAdress.getAddres01s())
                .enterAddress_2(billingAdress.getAddres02s())
                .clickCity(billingAdress.getCitys())
                .enterPostcodeField(billingAdress.getPostcodes())
                .enterPhoneField(billingAdress.getPhones())
                .enterEmailField(billingAdress.getEmails())
                .enterCommentsField(billingAdress.getCommentss());
    }
}