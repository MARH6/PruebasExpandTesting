
package com.pruebasexpandtesting.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddRemovePage {

    private WebDriver driver;

    private By botonAgregar = By.xpath(
        "//button[normalize-space()='Add Element']"
    );

    private By botonEliminar = By.xpath(
        "//button[normalize-space()='Delete']"
    );

    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.get(
            "https://practice.expandtesting.com/add-remove-elements"
        );
    }

    public void agregarElemento() {

        WebDriverWait espera = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );

        WebElement boton = espera.until(
            ExpectedConditions.visibilityOfElementLocated(
                botonAgregar
            )
        );

        boton.sendKeys(Keys.ENTER);
    }

    public void eliminarElemento() {

        WebDriverWait espera = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );

        WebElement boton = espera.until(
            ExpectedConditions.visibilityOfElementLocated(
                botonEliminar
            )
        );

        boton.sendKeys(Keys.ENTER);
    }

    public int contarElementos() {
        return driver.findElements(botonEliminar).size();
    }
}
