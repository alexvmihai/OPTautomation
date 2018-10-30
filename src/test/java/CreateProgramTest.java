import com.opt.base.BaseTest;
import com.opt.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by alex.mihai on 11/8/2017.
 */
public class CreateProgramTest extends BaseTest{
    private By manageProgram = By.cssSelector("li.menu-item:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");

    @Test (priority=2)
    public void CreateProgramTest() throws InterruptedException, IOException {
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

        if(driver.getPageSource().contains("My Dashboard")){
            WebElement exercise = driver.findElement(By.cssSelector("li.menu-item:nth-child(1) > span:nth-child(1)"));
            Actions mouseover = new Actions(driver);
            mouseover.moveToElement(exercise).build().perform();
            WebElement element = driver.findElement(By.cssSelector("li.menu-item:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
            Actions mouseover2 = new Actions(driver);
            mouseover2.click(element).build().perform();
            Thread.sleep(9000);
        }

        AboutMePageObject aboutMePage = new AboutMePageObject(driver);
        aboutMePage.waitForPageToLoad();
        aboutMePage.setHeight("180");
        aboutMePage.setWeight("99");
        aboutMePage.setMale();
        aboutMePage.setMedicalConditions();
        System.out.println("Your BMI is " + aboutMePage.getBMI());
        aboutMePage.setMyGoal();
        aboutMePage.acceptRecommendation();
        MyGoalPageObject myGoalPage = aboutMePage.acceptPrecaution();
        myGoalPage.waitForPageToLoad();
        System.out.println("Your goal weight is: " + myGoalPage.getGoalWeight());
        System.out.println("Your weight to lose is: " + myGoalPage.getWeightToLose());
        System.out.println("Your goal BMI is: " + myGoalPage.getGoalBMI());
        String expectedTooltip = "We have recommended a weight that is not in the ideal healthy weight range. This is a goal that is achievable based on your current height and weight.\n" +
                "You can use the slider to change the goal weight now or create a new goal once you have achieved your recommended weight.";
        String actualTooltip = myGoalPage.getNoticeText();
        Assert.assertTrue(expectedTooltip.equals(actualTooltip), "Tooltips do not match !" +"\nExpected: " + expectedTooltip + "\nActual: " + actualTooltip);
        SelectMyProgramPageObject selectProgramPage = myGoalPage.generateProgram();
        selectProgramPage.waitForPageToLoad();
        selectProgramPage.selectActive1();
        selectProgramPage.waitForTrajectoryToLoad();
        System.out.println(selectProgramPage.getActive1Text());
        System.out.println(selectProgramPage.getEstimatedText());
        System.out.println(selectProgramPage.parsedActive1Text());
        System.out.println(selectProgramPage.parsedEstimatedText());
        String matrixActive1Text = selectProgramPage.parsedActive1Text();
        String estimatedGoal = selectProgramPage.parsedEstimatedText();
        Assert.assertTrue(matrixActive1Text.equals(estimatedGoal), "Goal estimation does not match !" + "\nExpected: " + matrixActive1Text + "\nActual: " + estimatedGoal);
        MyPreferencesPageObject preferencesPage = selectProgramPage.setPreferences();
        preferencesPage.waitForPageToLoad();
        AccountDashboardPageObject dashboardPage = preferencesPage.startProgram();
        Thread.sleep(20000);
        dashboardPage.waitForDashboardPageToLoad();
        System.out.println("Program created, test passed !");

    }
}
