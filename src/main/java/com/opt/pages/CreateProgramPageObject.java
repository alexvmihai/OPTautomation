package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class CreateProgramPageObject extends BasePageObject<CreateProgramPageObject> {
    private By aboutMe = By.cssSelector(".step-title");
    private By contentRow = By.cssSelector(".above-content.row");
    private By programStepAbout = By.cssSelector("#program-step-about");

    protected CreateProgramPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(aboutMe);
        waitForVisibilityOf(contentRow);
        waitForVisibilityOf(programStepAbout);
    }

}
