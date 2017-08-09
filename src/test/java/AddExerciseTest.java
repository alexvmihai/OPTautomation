
import com.opt.pages.AccountDashboardPageObject;
import com.opt.pages.ExerciseTrackerPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class AddExerciseTest extends LoginTest {
    @Test (priority = 3)
    public void AddExerciseTest() throws InterruptedException {
        AccountDashboardPageObject dashboardPage = new AccountDashboardPageObject(driver);
        ExerciseTrackerPageObject exerciseTrackerPage = dashboardPage.openExerciseTrackerPage();
        exerciseTrackerPage.waitForExerciseTrackerPageToLoad();
        exerciseTrackerPage.addExercise();
        exerciseTrackerPage.addExerciseType();
        exerciseTrackerPage.addMinutes();
        exerciseTrackerPage.timeOfDay();
        exerciseTrackerPage.trackExercise();
        String currentDate = exerciseTrackerPage.getCurrentDate();
        System.out.println(currentDate);
        String expectedDate = exerciseTrackerPage.getDateText();
        String expectedExercise = "Weight Lifting - Moderate Moderate effort";
        String actualExercise = exerciseTrackerPage.getExerciseText();
        String expectedWhen = "Morning";
        String actualWhen = exerciseTrackerPage.getWhenText();
        String expectedDuration = "145 mins";
        String actualDuration = exerciseTrackerPage.getDurationText();
        //Validation
        Assert.assertTrue(currentDate.equals(expectedDate), "Invalid date ! \nCurrent Date: " + currentDate + "\nDate in exercise History: " + expectedDate);
        System.out.println("Dates match ! \nCurrent date :            " + currentDate + "\nDate in exercise History: " + expectedDate);

        Assert.assertTrue(expectedExercise.equals(actualExercise), "Invalid exercise ! \nExpected: " + expectedExercise + "\nActual: " + actualExercise);
        System.out.println("Exercise match ! \nExpected exercise: " + expectedExercise + "\nActual exercise: " + actualExercise);

        Assert.assertTrue(expectedWhen.equals(actualWhen), "Invalid when ! \nExpected When: " + expectedWhen + "\nActual When: " + actualWhen);
        System.out.println("Whens match ! \nExpected when: " + expectedWhen + "\nActual when: " + actualWhen);

        Assert.assertTrue(expectedDuration.equals(actualDuration), "Invalid duration ! \nExpected duration: " + expectedDuration + "\nActual duration: " + actualDuration);
        System.out.println("Durations match ! \nExpected duration: " + expectedDuration + "\nActual Duration: " + actualDuration);
        System.out.println("Test passed !");
    }
}
