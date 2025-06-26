import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class negativeUsernameTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        // Negative username login
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUser");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // Verify Error message display
        WebElement errMessage = driver.findElement(By.id("error"));
        if (errMessage.isDisplayed()){
            System.out.println("✅ Error Message display");
        }else {
            System.out.println("❌ Error Message not display");
        }

        // Verify error text
        String textMessage = errMessage.getText();
        if (textMessage.equals("Your username is invalid!")){
            System.out.println("✅ Text message is displayed: " + textMessage);
        }else {
            System.out.println("❌ Text message is not displayed : " + textMessage);
        }






    }
}
