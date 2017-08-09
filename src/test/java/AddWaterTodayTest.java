import com.opt.pages.AccountDashboardPageObject;
import com.opt.pages.MealTrackerPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 6/28/2017.
 */
public class AddWaterTodayTest extends LoginTest {
    @Test (priority=3)
    public void AddWaterTest() throws InterruptedException{
        AccountDashboardPageObject dashboardPage = new AccountDashboardPageObject(driver);
        MealTrackerPageObject mealTrackerPage = dashboardPage.openMealTracker();
        mealTrackerPage.waitForMealTrackerPageToLoad();
        mealTrackerPage.addWater("1500");
        System.out.println("Water successfully added !");
        String expectedAddedWater = "1500ml";
        String actualWaterHistory = mealTrackerPage.getWaterHistory();
        System.out.println(" ==========>> " + actualWaterHistory);
        Assert.assertTrue(expectedAddedWater.equals(actualWaterHistory), "Assert failed !" + "\nExpected water: " + expectedAddedWater + "\nActual water: " + actualWaterHistory);
        System.out.println("Assert successful ! \nExpected added water: " + expectedAddedWater + "\nActual added water: " + actualWaterHistory);
        mealTrackerPage.deleteWaterHistory();
        System.out.println("Test Passed !");
    }
}
