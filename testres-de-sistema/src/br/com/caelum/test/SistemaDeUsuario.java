package br.com.caelum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SistemaDeUsuario {

    private ChromeDriver driver;
    private HomeTrainingPage usuarios;
    private String xpath;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.usuarios = new HomeTrainingPage(driver);
    }

    @After
    public void finaliza() {
        driver.close();
    }

    @Test
    public void cadastrarUmNovoUsuarioSoComNomeEmail() {

        usuarios.visitaSiteTreinamento();
        usuarios.irParaPaginaDeCriarUsuario().preencheFormulario("aaaaaa", "souzin", "gabriel@teste.com");

        //Captura alerta de Criação de usuário com sucesso
        WebElement usuarioNovoCriado = driver.findElement(By.id("notice"));

        //Compara os resultados para confirmar a criação com sucesso
        assertEquals("Usuário Criado com sucesso", usuarioNovoCriado.getText());
    }

    @Test
    public void tentarCadastrarSemNome() {

        usuarios.visitaSiteTreinamento();
        usuarios.irParaPaginaDeCriarUsuario().preencheFormulario("", "cardozo", "kim@test.com");

        //Captura alerta de Criação de usuário com sucesso
        WebElement erroAoCriarUsuario = driver.findElement(By.id("error_explanation"));

        //Compara os resultados para confirmar a criação com sucesso
        assertEquals("1 error proibiu que este usuário fosse salvo:\n" +
                "Name translation missing: pt-BR.activerecord.errors.models.user.attributes.name.blank", erroAoCriarUsuario.getText());
    }

    @Test
    public void tentarCadastrarSemPreencherFormulario() {
        usuarios.visitaSiteTreinamento();
        usuarios.irParaPaginaDeCriarUsuario().criaUsuario();

        //Captura alerta de Criação de usuário com sucesso
        WebElement erroAoCriarUsuario = driver.findElement(By.id("error_explanation"));

        assertEquals("3 errors proibiu que este usuário fosse salvo:\n" +
                "Name translation missing: pt-BR.activerecord.errors.models.user.attributes.name.blank\n" +
                "Email translation missing: pt-BR.activerecord.errors.models.user.attributes.email.blank\n" +
                "Email translation missing: pt-BR.activerecord.errors.models.user.attributes.email.invalid", erroAoCriarUsuario.getText());

    }

    @Test
    public void excluirUsuario() throws InterruptedException {
        String pathDelete = "//a[contains(@href,'/users/3354') and @data-method='delete']";
        String pathEmail = "//td[contains(text(),'aaba@test.com')]";
        usuarios.visitaSiteTreinamento();
        usuarios.irParaListaDeUsuario().excluirUsuario(pathDelete);
        try {
            driver.findElement(By.xpath(pathEmail));
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
