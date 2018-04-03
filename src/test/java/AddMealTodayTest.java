import com.opt.pages.AccountDashboardPageObject;
import com.opt.pages.MealTrackerPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alex.mihai on 7/5/2017.
 */
public class AddMealTodayTest extends LoginTest{
    @Test (priority=3)
    public void AddMealTest() throws InterruptedException, IOException {
        AccountDashboardPageObject dashboardPage = new AccountDashboardPageObject(driver);
        MealTrackerPageObject mealTrackerPage = dashboardPage.openMealTracker();
        mealTrackerPage.waitForMealTrackerPageToLoad();
        mealTrackerPage.typeMeal("Big Mac Burger");
        mealTrackerPage.enterQTY("3");
        mealTrackerPage.selectMealTime("Lunch");
        mealTrackerPage.trackMeal();
        String food = "Big Mac Burger";
        String foodHistory = mealTrackerPage.getFoodHistory();
        Assert.assertTrue(foodHistory.contains(food), "Error, the meal was not added to the Food History !");
        System.out.println("Test passed ! The meal was added in the Food History !\n" + foodHistory );
    }
}
