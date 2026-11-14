
package com.pruebasexpandtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage {

    private WebDriver driver;

    private By checkbox1 = By.id("checkbox1");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.get("https://practice.expandtesting.com/checkboxes");
    }

    public void seleccionarCasilla() {

        WebElement casilla = driver.findElement(checkbox1);

        if (casilla.isSelected()) {
            casilla.sendKeys(Keys.SPACE);
        }

        casilla.sendKeys(Keys.SPACE);
    }

    public boolean estaSeleccionada() {
        return driver.findElement(checkbox1).isSelected();
    }
}
