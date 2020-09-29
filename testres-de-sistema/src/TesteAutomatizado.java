import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

    public static void main(String[] args) {
        //Abre o chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
                ChromeDriver driver = new ChromeDriver();
                
        // acessa o site do google
            driver.get("http://www.google.com.br/");

            // digita no campo "q" do google
            WebElement query = driver.findElement(By.name("q"));
            query.sendKeys("Caelum");

            // submete o form
            query.submit();
        }
}
