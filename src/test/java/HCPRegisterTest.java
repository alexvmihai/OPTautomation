import com.opt.base.BaseTest;
import com.opt.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by alex.mihai on 1/8/2018.
 */
public class HCPRegisterTest extends BaseTest {
    @Test (priority=1)
    public void HCPRegisterTest() throws InterruptedException, IOException {
        HomepageObject BEHomepage = new HomepageObject(driver);
        BEHomepage.openHomePage();
        BEHomepage.acceptPrompt();
        BEHomepage.waitForHomepageToLoad();
        HCPRegisterPageObject registerPage = BEHomepage.openHCPRegisterPage();
        registerPage.waitForPopUp();
        Assert.assertEquals(true, registerPage.agreePopUp(), "Disclaimer not closed !");
        Thread.sleep(7000);
        //Generate random email
        long Random = Math.round(Math.random() * 1357987.0D);
        String email = "amihai_test_hcp" + Random + "@mailinator.com";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);

        registerPage.fillInRegisterForm("Mr","Auto", "Robot", email, "Nutritionist", "Croc Avenue 12",
                "Akolele", "Australia", "Sidney","New South Wales", "2546", phone, "Optifast123/");

        HCPConfirmationPage hcpConfirmPage = registerPage.submitForm();
        //Captcha
        Thread.sleep(90000);
        hcpConfirmPage.waitForPageToLoad();
//        String expectedConfirmText = "Your account is awaiting approval. Your account has been created but needs to be approved " +
//                "by an administrator before you can sign in. An e-mail will be sent to your email address used to register when your account" +
//                " is ready for you to complete the setup!";
        String expectedConfirmText = "Your access is awaiting activation";
        String actualConfirmText = hcpConfirmPage.getConfirmText();
        Assert.assertTrue(expectedConfirmText.equals(actualConfirmText), "Texts do not match !" + "\nExpected: " + expectedConfirmText
                            + "\nActual: " + actualConfirmText);
        System.out.println("Registration submitted successfully !" + "\nYour account is : " + email );

        //Activate the account from admin

        BEHomePageObject adminHomepage = new BEHomePageObject(driver);
        adminHomepage.openHomepage();
        adminHomepage.acceptPrompt();
        adminHomepage.waitForPageToLoad();
        String[] credentials = adminHomepage.getCredentials("D:\\Access Credentials\\opt.txt");
        adminHomepage.fillCredentials(credentials[0], credentials[1]);
        BEDashboardPageObject dashboard = adminHomepage.clickLogin();
        dashboard.waitForPageToLoad();
        dashboard.closePopUp();
        dashboard.waitForPageToLoad();
        dashboard.mouseOverEwave();
        dashboard.mouseOverHCP();
        HCPRegistrationRequestsPageObject requestsPage = dashboard.clickHCPRequests();
        requestsPage.waitForPageToLoad();
        requestsPage.searchEmail(email);
        requestsPage.accredit();
        requestsPage.waitForMessage();
        String expectedMessage = "Hcp was activated successfully";
        String actualMessage = requestsPage.getMessage();
        Assert.assertTrue(expectedMessage.equals(actualMessage), "Success message is not correct !" + "\nExpected: " +
                                            expectedMessage + "\nActual: " + actualMessage);
        System.out.println("HCP Account accredited successfully !");

        //Reset pass from mail
        Thread.sleep(90000);
        MailinatorPageObject mailinator = new MailinatorPageObject(driver);
        mailinator.openMailinator();
        mailinator.waitForHomepageToLoad();
        mailinator.submitEmail(email);
        mailinator.clickGo();
        HCPDashboardPageObject hcpDashboard = mailinator.resetPass();
        driver.switchTo().window("_other");
//        resetPassPage.waitForPageToLoad();
//        resetPassPage.typePassword("Optifast123/");
//        resetPassPage.closeTerms();
//        LoginPageObject loginPage = resetPassPage.submit();
//        loginPage.waitForPassMsgToLoad();
//        String expectedMessagePass = "Your password has been updated.";
//        String actualMessagePass = loginPage.getPassUpdatedText();
//        Assert.assertTrue(expectedMessagePass.equals(actualMessagePass), "Password Update message does not match !" +
//                                "\nExpected: " + expectedMessagePass + "\nActual: " + actualMessagePass);

         //Login with the new account
//        loginPage.fillInCredentials(email, "Optifast123/");
//        HCPDashboardPageObject hcpDashboard = loginPage.clickLoginButtonHCP();
        hcpDashboard.waitForPageToLoad();
        String accreditation = hcpDashboard.getAccreditationID();
        System.out.println("Your accreditation id is: " + accreditation);
        System.out.println("Your password is Optifast123/");
        System.out.println("Test passed !");



    }

}
