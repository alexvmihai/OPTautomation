import com.opt.pages.AccountDashboardPageObject;
import com.opt.pages.MealTrackerPageObject;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 7/5/2017.
 */
public class AddMealTodayTest extends LoginTest{
    @Test (priority=3)
    public void AddMealTest() throws InterruptedException{
        AccountDashboardPageObject dashboardPage = new AccountDashboardPageObject(driver);
        MealTrackerPageObject mealTrackerPage = dashboardPage.openMealTracker();
        mealTrackerPage.waitForMealTrackerPageToLoad();
        mealTrackerPage.typeMeal("Chicken Big Mac Burger");
        mealTrackerPage.enterQTY("3");
        mealTrackerPage.selectMealTime("Lunch");
//        mealTrackerPage.trackMeal();
    }
}
