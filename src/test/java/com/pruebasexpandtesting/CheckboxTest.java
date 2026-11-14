
package com.pruebasexpandtesting;

import com.pruebasexpandtesting.pages.CheckboxPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {

    @Test
    public void CP04_seleccionarCasilla() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            CheckboxPage pagina = new CheckboxPage(driver);

            pagina.abrirPagina();
            pagina.seleccionarCasilla();

            assertTrue(
                pagina.estaSeleccionada(),
                "La casilla no quedo seleccionada"
            );

            System.out.println("CP-04: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }
}
