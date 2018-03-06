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
    private By resetPassHeader = By.cssSelector("h1.row");
    private By currentF = By.cssSelector("#current_password");
    private By newPassF = By.cssSelector("#password");
    private By confirmPassF = By.cssSelector("#confirmation");
    private By submitPass = By.cssSelector(".-arrow");


    protected CreateProgramPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(aboutMe);
        waitForVisibilityOf(contentRow);
        waitForVisibilityOf(programStepAbout);
    }

    public void resetPass(String current, String newPass, String confirm){
        type(current, currentF);
        type(newPass, newPassF);
        type(confirm, confirmPassF);
    }

    public AccountDashboardPageObject submitNewPass() throws InterruptedException {
        clickOn(submitPass);
        Thread.sleep(7000);
        return new AccountDashboardPageObject(driver);
    }

}
