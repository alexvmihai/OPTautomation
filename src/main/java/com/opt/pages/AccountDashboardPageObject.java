package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class AccountDashboardPageObject extends BasePageObject<AccountDashboardPageObject> {
    private By dashboardHeader = By.xpath("html/body/div[2]/div[1]/h1");
    private By weightProgress = By.xpath("html/body/div[2]/div[2]/div/div[1]");
    private By calorieBreakdown = By.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]");
    private By dailyWater = By.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]");
    private By exerciseTracker = By.cssSelector("li.menu-item:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");

    //Navbar

    private By mealPlanner = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[1]/a");
    private By mealTracker = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[2]/a");
    private By mealPreferences = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[3]/a");
    private By recipeInspiration = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/ul/li[4]/a");
    private By forum = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/span");
    private By communityForum = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/ul/li[1]/a");


    public AccountDashboardPageObject(WebDriver driver) throws IOException {
        super(driver);
    }
    public void waitForDashboardPageToLoad(){
        waitForVisibilityOf(dashboardHeader);
        waitForVisibilityOf(weightProgress);
        waitForVisibilityOf(calorieBreakdown);
        waitForVisibilityOf(dailyWater);
        System.out.println("Dashboard Page Loaded !");
    }
    public ExerciseTrackerPageObject openExerciseTrackerPage() throws IOException, InterruptedException {
        WebElement MyExercise = driver.findElement(By.cssSelector("li.menu-item:nth-child(3) > span:nth-child(1)"));
        Actions mouseover = new Actions(driver);
        mouseover.moveToElement(MyExercise).build().perform();
        WebElement ExerciseTracker = driver.findElement(By.cssSelector("li.menu-item:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
        Actions mouseover2 = new Actions(driver);
        mouseover.moveToElement(ExerciseTracker).build().perform();
        Thread.sleep(3000);
        clickOn(exerciseTracker);
        System.out.println("Exercise Tracker page opened !");
        return new ExerciseTrackerPageObject(driver);
    }

    public MealTrackerPageObject openMealTracker() throws IOException {
        System.out.println("Going to the Meal Tracker page...");
        WebElement myMeals = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[2]/span"));
        mouseOver(myMeals);
        clickOn(mealTracker);
        return new MealTrackerPageObject(driver);
    }



}
