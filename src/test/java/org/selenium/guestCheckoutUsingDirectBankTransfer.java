package org.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class guestCheckoutUsingDirectBankTransfer {

    @Test
    public void Dummytest() throws InterruptedException{

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_112.0.5615.49.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();

        // Launch Website
        driver.get("https://askomdch.com/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Test
        driver.findElement(By.xpath("(//li/a[contains(.,'Store')])[1]")).click();
        driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Blue");
        driver.findElement(By.xpath("//button[@value='Search']")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertEquals(
                  driver.findElement(By.xpath("//h1[contains(@class,'woocommerce-products-header__title page-title')]")).getText(),
                  "Search results: “Blue”"
        );

        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215'][contains(.,'Add to cart')]")).click();
        Thread.sleep(3000);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[@title='View cart']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(.,'Blue Shoes')]")).getText(),
                 "Blue Shoes"
        );
        Thread.sleep(4000);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("Test");
        driver.findElement(By.id("billing_last_name")).sendKeys("Test");
        driver.findElement(By.id("billing_company")).sendKeys("Testing ORG");
        driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
        driver.findElement(By.xpath("//span/ul/li[contains(.,'Peru')]")).click();
        driver.findElement(By.id("billing_address_1")).sendKeys("Chosica - Lima");
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
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(.,'Checkout')]")).getText(),
                "Checkout"
        );

        driver.close();
        driver.quit();

    }

    @Test
    public void testDemo() throws InterruptedException{

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_112.0.5615.49.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();

        // Launch Website
        driver.get("https://askomdch.com/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Test
        driver.findElement(By.xpath("(//li/a[contains(.,'Store')])[1]")).click();
        driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Blue");
        driver.findElement(By.xpath("//button[@value='Search']")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertEquals(
                driver.findElement(By.xpath("//h1[contains(@class,'woocommerce-products-header__title page-title')]")).getText(),
                "Search results: “Blue”"
        );

        driver.findElement(By.xpath("//a[@href='?add-to-cart=1215'][contains(.,'Add to cart')]")).click();
        Thread.sleep(3000);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[@title='View cart']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(.,'Blue Shoes')]")).getText(),
                "Blue Shoes"
        );
        Thread.sleep(4000);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]")).click();

        // Click here to login
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/div[@class='woocommerce-info']/a[contains(.,'Click here to login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form/p/input[@name='username']")).sendKeys("test170296@gmail.com");
        driver.findElement(By.xpath("//p/span/input[@id='password']")).sendKeys("1nd1.sm4rt%%");
        driver.findElement(By.xpath("//input[contains(@id,'rememberme')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='login']")).click();

        // Billing details
        driver.findElement(By.id("billing_first_name")).sendKeys("Test");
        driver.findElement(By.id("billing_last_name")).sendKeys("Test");
        driver.findElement(By.id("billing_company")).sendKeys("Testing ORG");
        driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
        driver.findElement(By.xpath("//span/ul/li[contains(.,'Peru')]")).click();
        driver.findElement(By.id("billing_address_1")).sendKeys("Chosica - Lima");
        driver.findElement(By.id("billing_address_2")).sendKeys("Perú 2023");
        driver.findElement(By.id("billing_city")).sendKeys("Lima");
        driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
        driver.findElement(By.xpath("//ul/li[@class='select2-results__option'][contains(.,'Lima')]")).click();
        driver.findElement(By.id("billing_postcode")).sendKeys("15744");
        driver.findElement(By.id("billing_phone")).sendKeys("978554490");
        // driver.findElement(By.id("billing_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("order_comments")).sendKeys("Orden de compra de prueba");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='payment_method_cod']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(.,'Checkout')]")).getText(),
                "Checkout"
        );

        driver.close();
        driver.quit();

    }

}