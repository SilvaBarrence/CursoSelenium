package br.com.caelum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CadastroDeUsuario {

    private ChromeDriver driver;

    @Before
    public void inicializa() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void finaliza() {
        driver.close();
    }

    @Test
    public void cadastrarUmNovoUsuarioSoComNomeEmail() {
        driver.get("https://automacaocombatista.herokuapp.com/users/new");

        //Captura os elementos em tela
        WebElement nome = driver.findElement(By.id("user_name"));
        WebElement sobrenome = driver.findElement(By.id("user_lastname"));
        WebElement email = driver.findElement(By.id("user_email"));

        //Preenche os elementos
        nome.sendKeys("AABA");
        sobrenome.sendKeys("Bananinha");
        email.sendKeys("aaba@test.com");

        //Cria o usuário
        WebElement salvarUsuarioNovo = driver.findElement(By.name("commit"));
        salvarUsuarioNovo.click();

        //Captura alerta de Criação de usuário com sucesso
        WebElement usuarioNovoCriado = driver.findElement(By.id("notice"));

        //Compara os resultados para confirmar a criação com sucesso
        assertEquals("Usuário Criado com sucesso", usuarioNovoCriado.getText());

        //Finaliza o teste
        driver.close();
    }

    @Test
    public void falharCadastroSemNome() {
        driver.get("https://automacaocombatista.herokuapp.com/users/new");

        //Captura os elementos em tela
        WebElement sobrenome = driver.findElement(By.id("user_lastname"));
        WebElement email = driver.findElement(By.id("user_email"));

        //Preenche os elementos
        sobrenome.sendKeys("Bananinha");
        email.sendKeys("aaba@test.com");

        //Cria o usuário
        WebElement salvarUsuarioNovo = driver.findElement(By.name("commit"));
        salvarUsuarioNovo.click();

        //Captura alerta de Criação de usuário com sucesso
        WebElement erroAoCriarUsuario = driver.findElement(By.id("error_explanation"));
        System.out.println(erroAoCriarUsuario);
        System.out.println(erroAoCriarUsuario.getText());

        //Compara os resultados para confirmar a criação com sucesso
        assertEquals("1 error proibiu que este usuário fosse salvo:\n" +
                "Name translation missing: pt-BR.activerecord.errors.models.user.attributes.name.blank", erroAoCriarUsuario.getText());

       //Finaliza o teste
        driver.close();
    }
}
