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
        String email = "alex.mihai.optaros+" + Random + "@gmail.com";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);
        String parola = "Optifast123/";

        registerPage.fillRegisterForm("Alex","Automation",email, "Street 256", "Darkwood", "2454", parola, parola,
                "Australia", "New South Wales");

        registerPage.agreeTerms();

        RegisterConfirmationPageObject confirmationPage = registerPage.submitForm();
        Thread.sleep(9000);
        confirmationPage.waitForConfirmationPage();

        String actualMsg = confirmationPage.getMessageText();
//        String expectedMsg = "Account confirmation is required. Please, check your email for the confirmation link. To resend the confirmation email please click here.";
        String expectedMsg = "Thank you for signing up. Please confirm your account by following the instructions in the email we’ve sent to you.";
        Assert.assertTrue(actualMsg.equals(expectedMsg), "Confirmation message doesn't match ! \nExpected: " + expectedMsg + "\nActual: " + actualMsg);
        System.out.println("******Confirmation message matches !******\n" + actualMsg);


        String actualBlock = confirmationPage.getBlockText();
        System.out.println(actualBlock);
        String expectedBlock = "Your registration has been received!";
        Assert.assertTrue(actualBlock.equals(expectedBlock), "Block  text doesn't match. \nExpected: " + expectedBlock + "\nActual: " + actualBlock);
        System.out.println("*******Block text matches !*******\n" + expectedBlock);
        System.out.println("Your account is " + email + " Password: " + parola);

        //Activate the account from the email
        Thread.sleep(3000);
        MailinatorPageObject gmail = new MailinatorPageObject(driver);
        gmail.openMailinator();
        gmail.waitForHomepageToLoad();
        gmail.submitEmail();
        CreateProgramPageObject programPage = gmail.clickToActivate();
        Thread.sleep(9000);
        //Switch to new tab
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        System.out.println(driver.getTitle());
//        driver.switchTo().window("OPTIFAST | Very Low Calorie Diet");

        //Login with the new credentials
//        if(setEnv() == "PPRD"){
//            HomepageObject homepage1 = new HomepageObject(driver);
//            homepage1.openHomePage();
//            homepage1.waitForHomepageToLoad();
//            LoginPageObject loginPage = homepage1.openLogin();
//            loginPage.waitForLoginPageToLoad();
//        String expectedMessage = "Thank you for registering with Nestlé Health Science.";
//        String actualMessage = loginPage.getSuccessMessageNewAccount();
//        System.out.println(actualMessage);
//        Assert.assertTrue(actualMessage.equals(expectedMessage), "Register message does not match ! \nExpected: " + expectedMessage + "\nActual: " + actualMessage);
//            loginPage.fillInCredentials(email, parola);
//            CreateProgramPageObject programPage2 = loginPage.clickLoginButtonNewAccount();
//        }


        if(driver.getPageSource().contains("your password has expired")){
            programPage.resetPass(parola, "Parola1234/", "Parola1234/");
            AccountDashboardPageObject dashboard = programPage.submitNewPass();
            dashboard.waitForDashboardPageToLoad();
            System.out.println("Password has been reset, dashboard loaded successfully ! \nNew password is: Parola1234/");

        } else {
            programPage.waitForPageToLoad();
            System.out.println("Test passed ! Account created successfully !");
        }

    }
}
