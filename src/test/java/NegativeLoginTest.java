import com.opt.base.BaseTest;
import com.opt.pages.HomepageObject;
import com.opt.pages.LoginPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NegativeLoginTest extends BaseTest {

    //Generate random email
    long Random = Math.round(Math.random() * 1357987.0D);
    String wrongEmail = "wrong_email" + Random + "@mailinator.com";
//    private String wrongEmail = "wrong@email.com";
    private String wrongPassword = "wrongPass";
    private String expectedErrorMsg = "Invalid login or password";
    @Test(priority=1)
    public void negativeLoginTest() throws InterruptedException, IOException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        homepage.waitForHomepageToLoad();
        LoginPageObject loginPage = homepage.openLogin();
        loginPage.waitForLoginPageToLoad();
        loginPage.fillInCredentials(wrongEmail, wrongPassword);
        loginPage.clickLoginButton();
        loginPage.waitForErrorMsgToLoad();
        String actualErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(expectedErrorMsg.equals(actualErrorMsg), "Error message incorrect !" + "\nExpected: " + expectedErrorMsg + "\nActual: " + actualErrorMsg);
        System.out.println("Login incorrect, expected error msg displayed ! \nTestPassed !");
    }
}
