package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by alex.mihai on 1/9/2018.
 */
public class ResetPasswordPageObject extends BasePageObject<ResetPasswordPageObject> {
    private By title = By.cssSelector(".title");
    private By passwordF = By.cssSelector("#password");
    private By confirmPasswordF = By.cssSelector("#confirmation");
    private By read = By.cssSelector("span.required");
    private By submit = By.cssSelector(".button.-arrow");
    private By termsOfUse = By.cssSelector("#modal-terms > svg:nth-child(3)");



    protected ResetPasswordPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(title);
        waitForVisibilityOf(passwordF);
        waitForVisibilityOf(confirmPasswordF);
        waitForVisibilityOf(submit);
    }

    public void typePassword(String password) throws InterruptedException {
        type(password, passwordF);
        type(password, confirmPasswordF);
//        Select select = new Select(driver.findElement(By.cssSelector("li.control:nth-child(4) > div:nth-child(1) > label:nth-child(2)")));
        clickOn(read);
        Thread.sleep(4000);
    }

    public LoginPageObject submit() throws IOException {
        clickOn(submit);
        System.out.println("Submitting new password...");
        return new LoginPageObject(driver);
    }

    public void closeTerms() throws InterruptedException {
        clickOn(termsOfUse);
        Thread.sleep(3000);
    }
}
