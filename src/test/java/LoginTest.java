import com.optifast.base.BaseTest;
import com.optifast.pages.AccountDashboardPageObject;
import com.optifast.pages.LoginPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class LoginTest extends BaseTest {
    private String email = "smoke_test_preprod@mailinator.com";
    private String password ="Smoketest123/";
    private String wrongEmail = "wrong@email.com";
    private String wrongPassword = "wrongPass";
    private String expectedErrorMsg = "The entered email address and password do not match our records. Please check your details and try again.";
    @Test(priority=2)
    public void positiveLoginTest() throws InterruptedException {
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.openLoginPage();
        loginPage.acceptPrompt();
        loginPage.waitForLoginPageToLoad();
        loginPage.fillInCredentials(email, password);
        AccountDashboardPageObject dashboardPage = loginPage.clickLoginButton();
        dashboardPage.waitForDashboardPageToLoad();
        System.out.println("Test Passed !");
    }
    @Test (priority=1)
    public void negativeLoginTest() throws InterruptedException {
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.openLoginPage();
        loginPage.acceptPrompt();
        loginPage.waitForLoginPageToLoad();
        loginPage.fillInCredentials(wrongEmail, wrongPassword);
        loginPage.clickLoginButton();
        loginPage.waitForErrorMsgToLoad();
        String actualErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(expectedErrorMsg.equals(actualErrorMsg), "Error message incorrect !" + "\nExpected: " + expectedErrorMsg + "\nActual: " + actualErrorMsg);
        System.out.println("Login incorrect, expected error msg displayed ! \nTestPassed !");
    }
}
