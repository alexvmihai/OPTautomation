import com.opt.base.BaseTest;
import com.opt.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class BERegisterTest extends BaseTest {
    @Test
    public void BERegisterTest() throws InterruptedException {
        BEHomePageObject homepage = new BEHomePageObject(driver);
        homepage.openHomepage();
        homepage.acceptPrompt();
        homepage.waitForPageToLoad();
        homepage.fillCredentials("optaros", "OptarosAdmin!123456%#$^&");
        BEDashboardPageObject dashboard = homepage.clickLogin();
        dashboard.waitForPageToLoad();
        dashboard.closePopUp();
        dashboard.waitForPageToLoad();
//        dashboard.clickCustomers();
        dashboard.mouseOverCustomers();
        BEManageCustomersPageObject manageCustomersPage = dashboard.clickManage();
        manageCustomersPage.waitForPageToLoad();
        BECustomerInfoPageObject customerInfoPage = manageCustomersPage.addCustomer();
        customerInfoPage.waitForPageToLoad();
        customerInfoPage.clickContinue();
        //Generate random email
        long Random = Math.round(Math.random() * 1357987.0D);
        String email = "amihai_test" + Random + "@mailinator.com";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);

        //Fill in customer info
        customerInfoPage.fillInCustomerDetails("Main Website", "Optaros", "Automated", email, "Yes", "Full membership", "13/10/1976", "Male",
                "No", "183", "89", "Optifast123/");

        customerInfoPage.clickAddresses();
        customerInfoPage.clickDefaultBilling();
        customerInfoPage.fillAddress("Optaros", "Automated", "Street 20", "Sidney","Australia", "New South Wales", "2302", phone);
        BECustomerEditPageObject customerEditPage = customerInfoPage.saveCustomer();
        customerEditPage.waitForPageToLoad();
        String successMSG = customerEditPage.getSuccessMsg();
        String expectedSuccessMSG = "The customer has been saved.";
        Assert.assertTrue(successMSG.equals(expectedSuccessMSG), "Success messages do not match !" + "\nExpected: " + expectedSuccessMSG + "\nActual: " + successMSG);
        System.out.println("Customer saved successfully ! \nExpected: " + expectedSuccessMSG + "\nActual: " + successMSG);





    }
}
