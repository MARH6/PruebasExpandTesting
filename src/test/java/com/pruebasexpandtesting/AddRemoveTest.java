
package com.pruebasexpandtesting;

import com.pruebasexpandtesting.pages.AddRemovePage;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveTest {

    @Test
    public void CP06_agregarEliminarElemento() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            AddRemovePage pagina = new AddRemovePage(driver);

            pagina.abrirPagina();

            WebDriverWait espera = new WebDriverWait(
                driver, Duration.ofSeconds(10)
            );

            assertEquals(
                0,
                pagina.contarElementos(),
                "La pagina ya contiene elementos"
            );

            pagina.agregarElemento();

            espera.until(d -> pagina.contarElementos() == 1);

            assertEquals(
                1,
                pagina.contarElementos(),
                "No se agrego el elemento"
            );

            pagina.eliminarElemento();

            espera.until(d -> pagina.contarElementos() == 0);

            assertEquals(
                0,
                pagina.contarElementos(),
                "No se elimino el elemento"
            );

            System.out.println("CP-06: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }
}


