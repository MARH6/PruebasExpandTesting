
package com.pruebasexpandtesting;

import com.pruebasexpandtesting.pages.DropdownPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownTest {

    @Test
    public void CP05_seleccionarOpcion() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            DropdownPage pagina = new DropdownPage(driver);

            pagina.abrirPagina();
            pagina.seleccionarOpcion();

            assertEquals(
                "Option 1",
                pagina.obtenerOpcionSeleccionada(),
                "La opcion seleccionada no es correcta"
            );

            System.out.println("CP-05: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }
}
