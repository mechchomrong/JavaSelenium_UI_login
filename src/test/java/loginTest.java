import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.lang.String;


public class loginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        // test login
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
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
        Boolean isDisplay = findbuttonlogout.isDisplayed();
        if (isDisplay){
            System.out.println(" ✅ Button logout is display");
        }else{
            System.out.println(" ❌ Button logout not display");
        }
        findbuttonlogout.click();



    //driver.close();
    }
}
