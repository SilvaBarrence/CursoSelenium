package br.com.caelum.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CriarUsuario {

    private final WebDriver driver;

    public CriarUsuario(WebDriver driver){
        this.driver = driver;
    }

    public void preencheFormulario(String nome, String sobrenome, String email) {
        //Captura os elementos em tela
        WebElement txtNome = driver.findElement(By.id("user_name"));
        WebElement txtSobrenome = driver.findElement(By.id("user_lastname"));
        WebElement txtEmail = driver.findElement(By.id("user_email"));

        //Preenche os elementos
        txtNome.sendKeys(nome);
        txtSobrenome.sendKeys(sobrenome);
        txtEmail.sendKeys(email);
        criaUsuario();
    }

    public void criaUsuario() {
        //Cria o usuário
        WebElement salvarUsuarioNovo = driver.findElement(By.name("commit"));
        salvarUsuarioNovo.click();
    }
}
