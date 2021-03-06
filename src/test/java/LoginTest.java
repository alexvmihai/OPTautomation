import com.opt.base.BaseTest;
import com.opt.pages.AccountDashboardPageObject;
import com.opt.pages.HomepageObject;
import com.opt.pages.LoginPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class LoginTest extends BaseTest {

//    private String expectedErrorMsg = "Login failed. Please check your details and try again.";
    @Test(priority=2)
    public void positiveLoginTest() throws InterruptedException, IOException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        homepage.waitForHomepageToLoad();
        LoginPageObject loginPage = homepage.openLogin();
        loginPage.waitForLoginPageToLoad();
        String[] credentials = loginPage.getCredentials("D:\\Access Credentials\\opt_login.txt");
        System.out.println(credentials);
        loginPage.fillInCredentials(credentials[0], credentials[1]);
        AccountDashboardPageObject dashboardPage = loginPage.clickLoginButton();
        dashboardPage.waitForDashboardPageToLoad();
        System.out.println("Test Passed !");
    }

}
