package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 11/8/2017.
 */
public class MyGoalPageObject extends BasePageObject<MyGoalPageObject> {
    private By notice = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div/p");
    private By header = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/h2");
    private By goalWeight = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/div[1]/div/div/div/input[2]");
    private By saveButton = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[3]/button[2]");
    private By weightToLose = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[2]/div");
    private By goalBMI = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div[3]/div");
    private By generateProgram = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[3]/button[3]");
    private By backButton = By.xpath("html/body/div[2]/div[2]/div/div/div[2]/form/div[3]/button[1]");

    protected MyGoalPageObject(WebDriver driver) {
        super(driver);
    }

    public String getNoticeText(){
        return getText(notice);
    }

    public String getGoalWeight(){
        return getText(goalWeight);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
        waitForVisibilityOf(saveButton);
        waitForVisibilityOf(generateProgram);
    }

    public String getWeightToLose(){
        return getText(weightToLose);
    }

    public String getGoalBMI(){
        return getText(goalBMI);
    }

    public SelectMyProgramPageObject generateProgram (){
        System.out.println("Generating program...");
        clickOn(generateProgram);
        return new SelectMyProgramPageObject(driver);
    }
}
