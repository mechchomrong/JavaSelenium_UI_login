import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class negativePasswordTest {
    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // Verify error message display
        WebElement errMessage = driver.findElement(By.id("error"));
        if (errMessage.isDisplayed()){
            System.out.println("Error Message display");
        }else {
            System.out.println("Error Message not display");
        }

        // Verify text
        String errText = errMessage.getText();
        if (errText.equals("Your password is invalid!")){
            System.out.println("Error message : " + errText);
        }else {
            System.out.println("Error message : " + errText);
        }
    }
}
