package br.com.caelum.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaDeUsuario {

    private final WebDriver driver;

    public ListaDeUsuario(WebDriver driver){
        this.driver = driver;
    }

    public void excluirUsuario(String path){
        WebElement idUsuario = driver.findElement(By.xpath(path));
        System.out.println(idUsuario);
        idUsuario.click();
        // pega o alert que está aberto
       Alert alert = driver.switchTo().alert();
        // confirma
        alert.accept();
    }
}
