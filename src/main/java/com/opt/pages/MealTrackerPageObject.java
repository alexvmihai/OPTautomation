package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/28/2017.
 */
public class MealTrackerPageObject extends BasePageObject<MealTrackerPageObject>{
    private By searchBox = By.xpath(".//*[@id='mealTrackerForm']/div[1]/div[1]/div/input");
    private By qty = By.xpath(".//*[@id='mealTrackerForm']/div[1]/div[2]/div[1]/div[1]/input");
    private By when = By.xpath(".//*[@id='mealTrackerForm']/div[1]/div[2]/div[2]/div/select");
    private By track = By.xpath(".//*[@id='addMealByTracker']");
    private By foodHistory = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/div");
    private By serving = By.xpath(".//*[@id='mealTrackerForm']/div[1]/div[2]/div[1]/div[2]/select");
    private By waterTracker = By.xpath(".//*[@id='water']");
    private By waterHistory = By.xpath(".//*[@id='water-history']/div/table/tbody/tr/td[1]");
    private By addWaterButton = By.xpath(".//*[@id='addWaterByTracker']");
    private By deleteWaterHistory = By.xpath(".//*[@class=\"remove js-delete-water\"]");
    protected JavascriptExecutor executor = (JavascriptExecutor)driver;

    protected MealTrackerPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForMealTrackerPageToLoad(){
        waitForVisibilityOf(searchBox);
        System.out.println("Meal Tracker Page Loaded !");
    }

    public void addWater(String qty) throws InterruptedException {
        System.out.println("Adding water, " + qty + " ml");
        type(qty, waterTracker);
        clickOn(addWaterButton);
        Thread.sleep(6000);
    }

    public String getWaterHistory(){
        return getText(waterHistory);
    }

    public void deleteWaterHistory(){
        executor.executeScript("javascript:window.scrollBy(0,500)");
        System.out.println("Deleting water history...");
        clickOn(deleteWaterHistory);
        System.out.println("Success !");
    }

    public void typeMeal(String name){
        System.out.println("Typing name of the food...");
        type(name, searchBox);
    }

    public void enterQTY(String minutes){
        System.out.println("Entering quantity...");
        type(minutes, qty);
    }

    public void selectMealTime(String time){
        System.out.println("Selecting meal time...");
        Select select = new Select(driver.findElement(By.xpath(".//*[@id='mealTrackerForm']/div[1]/div[2]/div[2]/div/select")));
        select.selectByVisibleText(time);
    }

    public void trackMeal() throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("Clicking on the track button...");
        clickOn(track);
        Thread.sleep(4000);
    }

    public String getFoodHistory(){
        return getText(foodHistory);
    }





}
