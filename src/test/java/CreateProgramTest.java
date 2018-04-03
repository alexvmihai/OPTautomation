import com.opt.base.BaseTest;
import com.opt.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by alex.mihai on 11/8/2017.
 */
public class CreateProgramTest extends RegisterTest{
    private By manageProgram = By.cssSelector("li.menu-item:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");

    @Test (priority=2)
    public void CreateProgramTest() throws InterruptedException, IOException {
        if(driver.getPageSource().contains("My Dashboard")){
            WebElement exercise = driver.findElement(By.cssSelector("li.menu-item:nth-child(1) > span:nth-child(1)"));
            Actions mouseover = new Actions(driver);
            mouseover.moveToElement(exercise).build().perform();
            WebElement element = driver.findElement(By.cssSelector("li.menu-item:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
            Actions mouseover2 = new Actions(driver);
            mouseover2.click(element).build().perform();
            Thread.sleep(9000);
        }

        AboutMePageObject aboutMePage = new AboutMePageObject(driver);
        aboutMePage.waitForPageToLoad();
        aboutMePage.setHeight("180");
        aboutMePage.setWeight("99");
        aboutMePage.setMale();
        aboutMePage.setMedicalConditions();
        System.out.println("Your BMI is " + aboutMePage.getBMI());
        aboutMePage.setMyGoal();
        aboutMePage.acceptPrecaution();
        MyGoalPageObject myGoalPage = aboutMePage.acceptRecommendation();
        myGoalPage.waitForPageToLoad();
        System.out.println("Your goal weight is: " + myGoalPage.getGoalWeight());
        System.out.println("Your weight to lose is: " + myGoalPage.getWeightToLose());
        System.out.println("Your goal BMI is: " + myGoalPage.getGoalBMI());
        String expectedTooltip = "We have recommended a weight that is not in the ideal healthy weight range. This is a goal that is achievable based on your current height and weight.\n" +
                "You can use the slider to change the goal weight now or create a new goal once you have achieved your recommended weight.";
        String actualTooltip = myGoalPage.getNoticeText();
        Assert.assertTrue(expectedTooltip.equals(actualTooltip), "Tooltips do not match !" +"\nExpected: " + expectedTooltip + "\nActual: " + actualTooltip);
        SelectMyProgramPageObject selectProgramPage = myGoalPage.generateProgram();
        selectProgramPage.waitForPageToLoad();
        selectProgramPage.selectActive1();
        selectProgramPage.waitForTrajectoryToLoad();
        System.out.println(selectProgramPage.getActive1Text());
        System.out.println(selectProgramPage.getEstimatedText());
        System.out.println(selectProgramPage.parsedActive1Text());
        System.out.println(selectProgramPage.parsedEstimatedText());
        String matrixActive1Text = selectProgramPage.parsedActive1Text();
        String estimatedGoal = selectProgramPage.parsedEstimatedText();
        Assert.assertTrue(matrixActive1Text.equals(estimatedGoal), "Goal estimation does not match !" + "\nExpected: " + matrixActive1Text + "\nActual: " + estimatedGoal);
        MyPreferencesPageObject preferencesPage = selectProgramPage.setPreferences();
        preferencesPage.waitForPageToLoad();
        AccountDashboardPageObject dashboardPage = preferencesPage.startProgram();
        Thread.sleep(20000);
        dashboardPage.waitForDashboardPageToLoad();
        System.out.println("Program created, test passed !");

    }
}
