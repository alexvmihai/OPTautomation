import com.opt.base.BaseTest;
import com.opt.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alex.mihai on 9/22/2017.
 */
public class RegisterTest extends BaseTest{


    @Test (priority=1)
    public void RegisterTest() throws InterruptedException, IOException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        homepage.waitForHomepageToLoad();
        RegisterPageObject registerPage = homepage.clickJoinNow();
        registerPage.waitForRegisterPageToLoad();
        //Generate random email
        long Random = Math.round(Math.random() * 1357987.0D);
        String email = "amihai_test" + Random + "@mailinator.com";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);

        registerPage.fillRegisterForm("Alex","Automation",email, "Street 256", "Darkwood", "2454", "Parola123/",
                "Parola123/", "New South Wales", "23", "May", "1979");

        registerPage.agreeTerms();

        RegisterConfirmationPageObject confirmationPage = registerPage.submitForm();
        confirmationPage.waitForConfirmationPage();

        String actualMsg = confirmationPage.getMessageText();
        String expectedMsg = "Account confirmation is required. Please, check your email for the confirmation link. To resend the confirmation email please click here.";
        Assert.assertTrue(actualMsg.equals(expectedMsg), "Confirmation message doesn't match ! \nExpected: " + expectedMsg + "\nActual: " + actualMsg);
        System.out.println("******Confirmation message matches !******\n" + actualMsg);


        String actualBlock = confirmationPage.getBlockText();
        System.out.println(actualBlock);
        String expectedBlock = "Thanks! You are almost there!\n" +
                "Please check your emails to activate your account.\n" +
                "We have sent you an activation email.\n" +
                "Please click on the link to confirm your email address and membership.\n" +
                "Once you have logged in your OPTIFAST ® VLCD™\n" +
                "Program will be ready for you to start your weight loss journey.\n" +
                "Simply go to MANAGE MY PROGRAM, then choose START NEW PROGRAM.\n" +
                "See you soon!";
        Assert.assertTrue(actualBlock.equals(expectedBlock), "Block  text doesn't match. \nExpected: " + expectedBlock + "\nActual: " + actualBlock);
        System.out.println("*******Block text matches !*******\n" + expectedBlock);
        System.out.println("Your account is " + email + " Password: Parola123/");

        //Activate the account from the email
        Thread.sleep(3000);
        MailinatorPageObject mailinator = new MailinatorPageObject(driver);
        mailinator.openMailinator();
        mailinator.waitForHomepageToLoad();
        mailinator.submitEmail(email);
        mailinator.clickGo();
        LoginPageObject loginPage = mailinator.clickToActivate();
        driver.switchTo().window("_other");

        //Login with the new credentials
        loginPage.waitForLoginPageToLoad();
        String expectedMessage = "Thank you for registering with Nestlé Health Science.";
        String actualMessage = loginPage.getSuccessMessageNewAccount();
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.equals(expectedMessage), "Register message does not match ! \nExpected: " + expectedMessage + "\nActual: " + actualMessage);
        loginPage.fillInCredentials(email, "Parola123/");
        CreateProgramPageObject programPage = loginPage.clickLoginButtonNewAccount();

        if(driver.getPageSource().contains("your password has expired")){
            programPage.resetPass("Parola123/", "Parola1234/", "Parola1234/");
            AccountDashboardPageObject dashboard = programPage.submitNewPass();
            dashboard.waitForDashboardPageToLoad();
            System.out.println("Password has been reset, dashboard loaded successfully ! \nNew password is: Parola1234/");

        } else {
            programPage.waitForPageToLoad();
            System.out.println("Test passed ! Account created successfully !");
        }

    }
}
