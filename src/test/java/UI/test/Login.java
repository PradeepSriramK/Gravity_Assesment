package UI.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://www.facebook.com/");
            
            driver.manage().window().maximize();
            
            WebElement usernameField = driver.findElement(By.id("email"));  
            WebElement passwordField = driver.findElement(By.id("pass"));   
            
            usernameField.sendKeys("your_email@example.com");
            passwordField.sendKeys("your_password");
            
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
