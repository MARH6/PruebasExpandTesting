
package com.pruebasexpandtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;

    private By lista = By.xpath("(//select)[1]");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.get("https://practice.expandtesting.com/dropdown");
    }

    public void seleccionarOpcion() {
        Select dropdown = new Select(
            driver.findElement(lista)
        );

        dropdown.selectByVisibleText("Option 1");
    }

    public String obtenerOpcionSeleccionada() {
        Select dropdown = new Select(
            driver.findElement(lista)
        );

        return dropdown.getFirstSelectedOption()
                       .getText().trim();
    }
}
