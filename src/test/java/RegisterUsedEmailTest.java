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
        String duplicateMail = "alex.mihai.optaros@gmail.com";
        String duplicateMailProd = "alex.mihai.optaros+0606@gmail.com";
        if (setEnv() == "PPRD"){
            registerPage.fillRegisterForm("Alex", "alex", duplicateMail, "Street 10", "Sidney", "2092", "Optifast123/", "Optifast123/",
                    "Australia","New South Wales");
        } else if (setEnv() == "PROD"){
            registerPage.fillRegisterForm("Alex", "alex", duplicateMailProd, "Street 10", "Sidney", "2092", "Optifast123/", "Optifast123/",
                     "Australia", "New South Wales");
        }

        Thread.sleep(5000);
        registerPage.agreeTerms();
        String expectedMsg = "Welcome back! You have already registered with a Nestlé brand. Please use your e-mail address to login or reset your password.";
        String actualMsg = registerPage.getDuplicateEmailMsg();
        Assert.assertTrue(expectedMsg.equals(actualMsg), "Messages don't match !" + "\nExpected: " + expectedMsg + "\nActual: " + actualMsg);


    }
}
