import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;
import java.time.Duration;


public class loginTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        // test login
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("student");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("Password123");

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submit.click();

        //Check it contain expected url
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("practicetestautomation.com/logged-in-successfully/")){
            System.out.println(" Login successful ");
        }else{
            System.out.println(" Login cause");
        }

        // test contain text
        WebElement text = driver.findElement(By.className("post-title"));
        String messagetext = text.getText();
        if (messagetext.contains("Congratulations")  || messagetext.contains("successfully logged in")){
            System.out.println("✅ Success message verified: " + messagetext);
        }else {
            System.out.println("❌ Expected text not found. Actual: " + messagetext);
        }

        // Verify button log out display in new page

        WebElement findbuttonlogout = driver.findElement(By.linkText("Log out"));
        boolean isDisplay = findbuttonlogout.isDisplayed();
        if (isDisplay){
            System.out.println(" ✅ Button logout is display");
        }else{
            System.out.println(" ❌ Button logout not display");
        }
        findbuttonlogout.click();



    //driver.close();
    }
}
