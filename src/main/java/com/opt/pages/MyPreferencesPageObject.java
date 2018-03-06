package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 11/15/2017.
 */
public class MyPreferencesPageObject extends BasePageObject<MyPreferencesPageObject> {

    private By header = By.xpath("html/body/div[2]/div[2]/div/div/div[4]/h2");
    private By startProgram = By.xpath("html/body/div[2]/div[2]/div/div/div[4]/form/div[3]/button[3]");

    protected MyPreferencesPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
        waitForVisibilityOf(startProgram);
    }

    public AccountDashboardPageObject startProgram(){
        System.out.println("Starting program ...");
        clickOn(startProgram);
        return new AccountDashboardPageObject(driver);
    }
}
