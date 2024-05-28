package testsuite;
/*
Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the text “Secure Area”
2. verifyTheUsernameErrorMessage
* Enter “tomsmith1” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the error message “Your username is invalid!”
3. verifyThePasswordErrorMessage
* Enter “tomsmith” username
* Enter “SuperSecretPassword” password
* Click on ‘LOGIN’ button
* Verify the error message “Your password is invalid!”
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    /*
    . userSholdLoginSuccessfullyWithValidCredentials
    * Enter “tomsmith” username
    * Enter “SuperSecretPassword!” password
    * Click on ‘LOGIN’ button
    * Verify the text “Secure Area”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[contains(text(), 'Secure Area')]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    /*
    2. verifyTheUsernameErrorMessage
    * Enter “tomsmith1” username
    * Enter “SuperSecretPassword!” password
    * Click on ‘LOGIN’ button
    * Verify the error message “Your username is invalid!”
     */
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    /*
    verifyThePasswordErrorMessage
    * Enter “tomsmith” username
    * Enter “SuperSecretPassword” password
    * Click on ‘LOGIN’ button
    * Verify the error message “Your password is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Verify the error message “Your password is invalid!”
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
