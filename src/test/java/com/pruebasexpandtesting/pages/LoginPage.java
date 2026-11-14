
package com.pruebasexpandtesting.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usuario = By.id("username");
    private By contrasena = By.id("password");
    private By botonLogin = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.get("https://practice.expandtesting.com/login");
    }

    public void iniciarSesion(String user, String password) {
        driver.findElement(usuario).sendKeys(user);
        driver.findElement(contrasena).sendKeys(password);
        driver.findElement(botonLogin).sendKeys(Keys.ENTER);
    }
}
