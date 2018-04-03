import com.opt.base.BaseTest;
import com.opt.pages.HomepageObject;
import com.opt.pages.RegisterPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alex.mihai on 11/3/2017.
 */
public class RegisterUsedEmailTest extends BaseTest{
    @Test
    public void RegisterUsedEmailTest() throws InterruptedException, IOException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        homepage.waitForHomepageToLoad();
        RegisterPageObject registerPage = homepage.clickJoinNow();
        registerPage.waitForRegisterPageToLoad();
        String duplicateMail = "alex_optifast3@mailinator.com";
        String duplicateMailProd = "alex_optifast2208@mailinator.com";
        if (setEnv() == "PPRD"){
            registerPage.fillRegisterForm("Alex", "alex", duplicateMail, "Street 10", "Sidney", "2092", "Opifast123/", "Optifast123/",
                    "Australia","New South Wales", "20", "May", "1988");
        } else if (setEnv() == "PROD"){
            registerPage.fillRegisterForm("Alex", "alex", duplicateMailProd, "Street 10", "Sidney", "2092", "Opifast123/", "Optifast123/",
                     "Australia", "New South Wales", "20", "May", "1988");
        }

        Thread.sleep(5000);
        registerPage.agreeTerms();
        String expectedMsg = "Email address already registered. Please login now or use a different email address.";
        String actualMsg = registerPage.getDuplicateEmailMsg();
        Assert.assertTrue(expectedMsg.equals(actualMsg), "Messages don't match !" + "\nExpected: " + expectedMsg + "\nActual: " + actualMsg);


    }
}
