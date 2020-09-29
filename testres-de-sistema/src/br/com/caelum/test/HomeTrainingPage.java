package br.com.caelum.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeTrainingPage {

    private final WebDriver driver;

    public HomeTrainingPage(WebDriver driver){
        this.driver = driver;
    }

    public void visitaSiteTreinamento() {
        driver.get("https://automacaocombatista.herokuapp.com/treinamento/home");
    }

    public CriarUsuario irParaPaginaDeCriarUsuario() {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a")).click();
        return new CriarUsuario(driver);
    }

}
