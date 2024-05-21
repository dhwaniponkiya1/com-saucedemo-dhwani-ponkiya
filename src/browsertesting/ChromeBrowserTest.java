package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class ChromeBrowserTest {
    static String baseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        //Setup chrome browser
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //To get the title of the page
        System.out.println("Title of page " + driver.getTitle());
        //Get current URL
        System.out.println("Current URL " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page source " + driver.getPageSource());

        //Enter credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();

        System.out.println("Current URL " + driver.getCurrentUrl());
        driver.navigate().to(baseUrl);       //navigate to base url
        driver.navigate().refresh();        //refresh the page
        driver.quit();          //close browser
    }
}
