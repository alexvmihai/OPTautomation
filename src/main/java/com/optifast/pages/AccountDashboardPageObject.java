package com.optifast.pages;

import com.optifast.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class AccountDashboardPageObject extends BasePageObject<AccountDashboardPageObject> {
    private By dashboardHeader = By.xpath("html/body/div[2]/div[1]/h1");
    private String exerciseTrackerURL = "https://preprod.optifast.com.au/member/exercise/#fndtn-exercise-tracker-tab";

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


}
