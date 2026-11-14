
package com.pruebasexpandtesting.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage {

    private WebDriver driver;

    private By botonLogout = By.linkText("Logout");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public void cerrarSesion() {

        WebDriverWait espera = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );

        WebElement boton = espera.until(
            ExpectedConditions.visibilityOfElementLocated(
                botonLogout
            )
        );

        boton.sendKeys(Keys.ENTER);
    }
}
