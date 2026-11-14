
package com.pruebasexpandtesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaConexionTest {

    @Test
    public void abrirPaginaExpandTesting() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://practice.expandtesting.com/");

            String urlActual = driver.getCurrentUrl();

            System.out.println("Titulo: " + driver.getTitle());
            System.out.println("URL: " + urlActual);

            assertTrue(
                urlActual.startsWith("https://practice.expandtesting.com/"),
                "La pagina no se abrio correctamente"
            );

        } finally {
            driver.quit();
        }
    }
}
