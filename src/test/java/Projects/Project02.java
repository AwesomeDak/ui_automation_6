package Projects;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

public class Project02 extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test(priority = 1, description = "TC01 - Validate the login form")
    public void validateLoginForm() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement usernameLabel = driver.findElement(By.xpath("//input[@id='username']/../label"));

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement passwordLabel = driver.findElement(By.xpath("//input[@id='password']/../label"));

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(usernameInputBox.getAttribute("required")));
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(passwordInputBox.getAttribute("required")));
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());

        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "TC02 - Validate the valid login")
    public void ValidateValidLogin() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");

        loginButton.click();

        WebElement successLoginMessage = driver.findElement(By.id("success_lgn"));
        Assert.assertTrue(successLoginMessage.isDisplayed());

        WebElement logoutButton = driver.findElement(By.id("logout"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Test(priority = 3, description = "TC03 - Validate the logout")
    public void ValidateLogOut() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        Waiter.pause(1);

        loginButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();

        WebElement loginForm = driver.findElement(By.className("pr-6"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    @Test(priority = 4, description = "TC04 - Validate the Forgot Password? Link and Reset Password modal")
    public void validateForgotPassword() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();

        WebElement modalHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertTrue(modalHeading.isDisplayed());

        WebElement closeButton = driver.findElement(By.className("delete"));
        Assert.assertTrue(closeButton.isDisplayed());

        WebElement emailInputBox = driver.findElement(By.id("email"));
        Assert.assertTrue(emailInputBox.isDisplayed());

        WebElement labelOfEmail = driver.findElement(By.cssSelector("label[for='email']"));
        Assert.assertEquals(labelOfEmail.getText(), "Enter your email address and we'll send you a link to reset your password.");

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    @Test(priority = 5, description = "TC05 - Validate the Reset Password modal close button")
    public void validateResetPassword() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();

        WebElement modalHeading = driver.findElement(By.cssSelector(".modal"));

        WebElement closeButton = driver.findElement(By.className("delete"));
        closeButton.click();

        try {
            Assert.assertFalse(modalHeading.isDisplayed());
        } catch (StaleElementReferenceException e) {
            Assert.assertTrue(true);
        }

        Waiter.pause(1);
    }

    @Test(priority = 6, description = "TC06 - Validate the Reset Password form submission")
    public void validateFormMessage() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();

        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.sendKeys("abcd@gmail.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(confirmationMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    @Test(priority = 7, description = "TC07 - Validate the invalid login with the empty credentials")
    public void validateInvalidLoginWithEmptyCredentials() {
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "TC08 -  Validate the invalid login with the wrong username")
    public void validateInvalidLoginWithWrongUsername() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        usernameInputBox.sendKeys("John");

        Waiter.pause(1);

        passwordInputBox.sendKeys("Test1234");

        Waiter.pause(1);

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "TC09 -  Validate the invalid login with the wrong password")
    public void validateInvalidLoginWithWrongPassword() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("TechGlobal");
        Waiter.pause(1);
        passwordInputBox.sendKeys("1234");
        Waiter.pause(1);

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 10, description = "TC10 - Validate the invalid login with the wrong username and password")
    public void validateInvalidLoginWithWrongPasswordAndUsername() {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));

        usernameInputBox.sendKeys("John");
        Waiter.pause(1);
        passwordInputBox.sendKeys("1234");
        Waiter.pause(1);

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
}
