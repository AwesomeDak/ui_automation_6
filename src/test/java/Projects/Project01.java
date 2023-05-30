package Projects;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

import java.util.List;

public class Project01 extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test(priority = 1, description = "TC01 - Validate the Contact Us information")
    public void validateContactUs() {
        WebElement mainHeading = driver.findElement(By.cssSelector(".is-size-2"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phoneNumber = driver.findElement(By.id("phone-number"));

        Assert.assertTrue(mainHeading.isDisplayed());
        Assert.assertEquals(mainHeading.getText(), "Contact Us");

        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");

        Assert.assertTrue(phoneNumber.isDisplayed());
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");
    }

    @Test(priority = 2, description = "TC02 - Validate the Full name input box")
    public void ValidateTheFullNameInputBox(){
        WebElement fullName = driver.findElement(By.cssSelector(".input"));
        WebElement fullNameLabel = driver.findElement(By.cssSelector("label[for='name']"));
        String fullNamePlaceholder = fullName.getAttribute("placeholder");

        Assert.assertTrue(fullName.isDisplayed());
        Assert.assertEquals(fullName.getAttribute("required"),"true");

        Assert.assertTrue(fullNameLabel.isDisplayed());

        Assert.assertEquals(fullNamePlaceholder, "Enter your full name");
    }

    @Test(priority = 3, description = "TC03 - Validate the Gender radio button")
    public void genderRadioButton(){
        WebElement genderLabel = driver.findElement(By.cssSelector("label[class='label']"));
        WebElement gender = driver.findElement(By.cssSelector("input[class='mr-1']"));
        List<WebElement> genderOptionsLabel = driver.findElements(By.cssSelector(".control label.radio"));
        List<WebElement> genderOptionsInput = driver.findElements(By.cssSelector(".control label input[type='radio']"));
        String[] genders = {"Male", "Female", "Prefer not to disclose"};

        Assert.assertTrue(genderLabel.isDisplayed());

        Assert.assertEquals(gender.getAttribute("required"),"true");
        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(genderOptionsLabel.get(i).getText(), genders[i]);
            Assert.assertTrue(genderOptionsLabel.get(i).isEnabled());
            Assert.assertFalse(genderOptionsLabel.get(i).isSelected());
        }

        genderOptionsInput.get(0).click();

        genderOptionsInput.get(1).click();
    }

    @Test(priority = 4, description = "TC 04 - Validate the Address input box")
    public void validateAddress() {
        WebElement addressInbox = driver.findElement(By.cssSelector("input[placeholder*='address']"));
        WebElement addressLabel = driver.findElement(By.xpath("//input[contains (@placeholder, 'address')]/../../label"));
        WebElement addressPlaceholder = driver.findElement(By.cssSelector("input[placeholder*=address]"));

        Assert.assertTrue(addressInbox.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(addressInbox.getAttribute("required")));

        Assert.assertEquals(addressLabel.getText(), "Address");

        Assert.assertEquals(addressPlaceholder.getAttribute("placeholder"), "Enter your address");
    }

    @Test(priority = 5, description = "TC05 - Validate the Email input box")
    public void validateEmail() {
        WebElement email = driver.findElement(By.cssSelector("input[type*='email']"));
        WebElement emailLabel = driver.findElement(By.xpath("//input[contains (@type, 'email')]/../../label"));
        WebElement emailPlaceholder = driver.findElement(By.cssSelector("input[type*='email']"));

        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getAttribute("required"), "true");

        Assert.assertEquals(emailLabel.getText(), "Email *");

        Assert.assertEquals(emailPlaceholder.getAttribute("placeholder"), "Enter your email");
    }

    @Test(priority = 6, description = "TC06 - Validate the Phone input box")
    public void validatePhone() {
        WebElement phone = driver.findElement(By.cssSelector("input[type*='phone']"));
        WebElement phoneLabel = driver.findElement(By.xpath("//input[contains (@type, 'phone')]/../../label"));
        WebElement phonePlaceholder = driver.findElement(By.cssSelector("input[type*='phone']"));

        Assert.assertTrue(phone.isDisplayed());
        Assert.assertFalse(Boolean.parseBoolean(phone.getAttribute("required")));

        Assert.assertEquals(phoneLabel.getText(), "Phone");

        Assert.assertEquals(phonePlaceholder.getAttribute("placeholder"), "Enter your phone number");
    }

    @Test(priority = 7, description = "TC07 - Validate the Message text area")
    public void validateMessage() {
        WebElement message = driver.findElement(By.cssSelector(".textarea"));
        WebElement messageLabel = driver.findElement(By.xpath("//textarea[@class]/../../label"));
        WebElement messagePlaceholder = driver.findElement(By.xpath("//textarea[@class]"));

        Assert.assertTrue(message.isDisplayed());

        Assert.assertEquals(messageLabel.getText(), "Message");

        Assert.assertEquals(messagePlaceholder.getAttribute("placeholder"), "Type your message here...");

    }

    @Test(priority = 8, description = "TC08 - Validate the Consent checkbox")
    public void validateConsentCheckBox() {
        WebElement consentLabel = driver.findElement(By.cssSelector("label.checkbox"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        Assert.assertEquals(consentLabel.getText(), "I give my consent to be contacted.");

        Assert.assertEquals(consentCheckBox.getAttribute("required"), "true");
        Assert.assertTrue(consentCheckBox.isEnabled());

        consentCheckBox.click();

        Assert.assertTrue(consentCheckBox.isSelected());

        consentCheckBox.click();

        Assert.assertFalse(consentCheckBox.isSelected());

    }

    @Test(priority = 9, description = "TC09 - Validate the SUBMIT button")
    public void validatesubmission() {
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    @Test(priority = 10, description = "TC10 - Validate the form submission")
    public void validateEnter() {
        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        List<WebElement> genderOptionsLabel = driver.findElements(By.cssSelector(".control label.radio"));
        WebElement addressLabel = driver.findElement(By.cssSelector("input[placeholder*='address']"));
        WebElement email = driver.findElement(By.cssSelector("input[placeholder*='email']"));
        WebElement phone = driver.findElement(By.cssSelector("input[placeholder*='phone']"));
        WebElement message = driver.findElement(By.cssSelector(".textarea"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));



        fullNameInputBox.sendKeys("Assem");

        genderOptionsLabel.get(0).click();
        Waiter.pause(3);

        addressLabel.sendKeys("Chiraq");
        Waiter.pause(3);

        email.sendKeys("assemdak@gmail.com");
        Waiter.pause(3);

        phone.sendKeys("(630) 484-5868");

        message.sendKeys("Be lowkey and stay humble");

        consentCheckBox.click();

        submitButton.click();

        WebElement formMessage = driver.findElement(By.cssSelector(".mt-5"));
        Assert.assertEquals(formMessage.getText(), "Thanks for submitting!");


    }
}
