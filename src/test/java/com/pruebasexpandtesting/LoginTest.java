package com.pruebasexpandtesting;

import com.pruebasexpandtesting.pages.SecurePage;
import com.pruebasexpandtesting.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;

public class LoginTest {

    @Test
    public void CP01_inicioSesionExitoso() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            LoginPage login = new LoginPage(driver);

            login.abrirPagina();
            login.iniciarSesion(
                    "practice",
                    "SuperSecretPassword!"
            );

            WebDriverWait espera = new WebDriverWait(
                    driver, Duration.ofSeconds(10)
            );

            assertTrue(
                    espera.until(
                            ExpectedConditions.urlContains("/secure")
                    ),
                    "El usuario no ingreso al area segura"
            );

            System.out.println("CP-01: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }

    @Test
    public void CP02_inicioSesionIncorrecto() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            LoginPage login = new LoginPage(driver);

            login.abrirPagina();
            login.iniciarSesion(
                    "usuarioincorrecto",
                    "SuperSecretPassword!"
            );

            WebDriverWait espera = new WebDriverWait(
                    driver, Duration.ofSeconds(10)
            );

            String mensaje = espera.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//*[@id='flash' or @role='alert' "
                                    + "or contains(@class,'alert')]"
                            )
                    )
            ).getText();

            assertTrue(
                    mensaje.toLowerCase().contains("username")
                    && mensaje.toLowerCase().contains("invalid"),
                    "Mensaje inesperado: " + mensaje
            );

            assertTrue(
                    driver.getCurrentUrl().contains("/login"),
                    "El sistema permitio ingresar con usuario incorrecto"
            );

            System.out.println("CP-02: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }

    @Test
    public void CP03_cierreSesionExitoso() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            LoginPage login = new LoginPage(driver);

            login.abrirPagina();
            login.iniciarSesion(
                    "practice",
                    "SuperSecretPassword!"
            );

            WebDriverWait espera = new WebDriverWait(
                    driver, Duration.ofSeconds(10)
            );

            assertTrue(
                    espera.until(
                            ExpectedConditions.urlContains("/secure")
                    ),
                    "No se pudo iniciar sesion"
            );

            SecurePage segura = new SecurePage(driver);
            segura.cerrarSesion();

            assertTrue(
                    espera.until(
                            ExpectedConditions.urlContains("/login")
                    ),
                    "El usuario no regreso al login"
            );

            System.out.println("CP-03: Prueba exitosa");

        } finally {
            driver.quit();
        }
    }

}
