import com.optifast.base.BaseTest;
import com.optifast.pages.HomepageObject;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class OpenHomepageTest extends BaseTest {
    @Test
    public void openHomepage() throws InterruptedException {
        HomepageObject homePage = new HomepageObject(driver);
        homePage.openHomePage();
        homePage.acceptPrompt();
        homePage.waitForHomepageToLoad();
        System.out.println("Homepage Opened, Test passed !");
    }
}
