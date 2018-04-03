package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/27/2017.
 */
public class ExerciseTrackerPageObject extends BasePageObject<ExerciseTrackerPageObject> {
    private By questionHeader = By.xpath(".//*[@id='exercise-tracker-tab']/div/div[4]/h2");
//    private By exerciseCategory = By.xpath(".//*[@class=\"field\"]//*[@class=\"input-box\"]//*[@id='exerciseCategory']");
//    private By exerciseType = By.xpath(".//*[@class=\"field\"]//*[@class=\"input-box\"]//*[@id='exerciseType']");
    private By minutes = By.xpath(".//*[@id='exercise_time_input']");
//    private By when = By.xpath(".//*[@id='exerciseTrackerForm']/div/div[2]/div[2]/div/select");
    private By trackButton = By.xpath(".//*[@id='exerciseTrackerForm']/div/div[2]/div[3]/button");
    private By addCustomExercise = By.xpath(".//*[@id='exerciseTrackerForm']/span");
    protected JavascriptExecutor executor = (JavascriptExecutor)driver;


    //Validation

    private By date = By.xpath(".//*[@id='exercise-history']/table/tbody/tr[1]/td[1]");
    private By exercise = By.xpath(".//*[@id='exercise-history']/table/tbody/tr[1]/td[2]");
    private By when = By.xpath(".//*[@id='exercise-history']/table/tbody/tr[1]/td[3]");
    private By duration = By.xpath(".//*[@id='exercise-history']/table/tbody/tr[1]/td[4]");


    protected ExerciseTrackerPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForExerciseTrackerPageToLoad() throws InterruptedException {
        waitForVisibilityOf(questionHeader);
        System.out.println("Exercise Tracker page loaded !");
        Thread.sleep(4000);

    }
    public void addExercise() throws InterruptedException {
        Select select = new Select(driver.findElement(By.xpath(".//*[@class=\"field\"]//*[@class=\"input-box\"]//*[@id='exerciseCategory']")));
        select.selectByVisibleText("Weight Lifting");
        executor.executeScript("javascript:window.scrollBy(0,500)");
//        type("Weight lifting", exerciseCategory);
//        Thread.sleep(3000);
        System.out.println("Selected \"Weight lifting\" !");
//

    }

    public void addExerciseType(){
        Select select = new Select(driver.findElement(By.xpath(".//*[@class=\"field\"]//*[@class=\"input-box\"]//*[@id='exerciseType']")));
        select.selectByVisibleText("Moderate effort");
//        type("Moderate effort", exerciseType);
        System.out.println("Selected \"Moderate effort\" !");
    }

    public void addMinutes(){
        System.out.println("Typing minutes..");
        type("45", minutes);
    }

    public void timeOfDay(){
        Select select = new Select(driver.findElement(By.xpath(".//*[@id='exerciseTrackerForm']/div/div[2]/div[2]/div/select")));
        select.selectByVisibleText("Morning");
        System.out.println("Selected \"Morning\"");
    }

    public void trackExercise() throws InterruptedException {
        System.out.println("Clicking on \"Track\" button..");
        clickOn(trackButton);
        Thread.sleep(10000);
    }

    public String getDateText(){
        return getText(date);
    }

    public String getExerciseText(){
        return getText(exercise);
    }
    public String getWhenText(){
        return getText(when);
    }
    public String getDurationText(){
        return getText(duration);
    }


}
