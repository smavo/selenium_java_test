package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        // PageFactory.initElements(driver, this); // Aplicarlo solo si lo usamos de manera general el Page Factory
    }

    public void load(String endPoint){
        driver.get("https://askomdch.com"+endPoint);
    }

    // Usando espera implicit
    public void waitForOverlayToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Iniciando Validador de Overlay y su tamaño es mayor a: " + overlays.size());
        if(overlays.size() > 0) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("El Overlay se pone invisible");
        } else {
            System.out.println("El Overlay no se encuentra");
        }
    }

    // Usando espera explicit
    public void waitForOverlayToDisappear2(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Iniciando Validador de Overlay y su tamaño es mayor a: " + overlays.size());
        if(overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("El Overlay se pone invisible");
        } else {
            System.out.println("El Overlay no se encuentra");
        }
    }

    public WebElement getElement(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
