package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class AccountDashboardPageObject extends BasePageObject<AccountDashboardPageObject> {
    private By dashboardHeader = By.xpath("html/body/div[2]/div[1]/h1");
    private String exerciseTrackerURL = "https://preprod.opt.com.au/member/exercise/#fndtn-exercise-tracker-tab";

    //Navbar

    private By mealPlanner = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[1]/a");
    private By mealTracker = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[2]/a");
    private By mealPreferences = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[3]/a");
    private By recipeInspiration = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[4]/a");


    public AccountDashboardPageObject(WebDriver driver) {
        super(driver);
    }
    public void waitForDashboardPageToLoad(){
        waitForVisibilityOf(dashboardHeader);
        System.out.println("Dashboard Page Loaded !");
    }
    public ExerciseTrackerPageObject openExerciseTrackerPage(){
        getPage(exerciseTrackerURL);
        System.out.println("Exercise Tracker page opened !");
        return new ExerciseTrackerPageObject(driver);
    }

    public MealTrackerPageObject openMealTracker(){
        System.out.println("Going to the Meal Tracker page...");
        WebElement myMeals = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/span"));
        mouseOver(myMeals);
        clickOn(mealTracker);
        return new MealTrackerPageObject(driver);
    }

}
