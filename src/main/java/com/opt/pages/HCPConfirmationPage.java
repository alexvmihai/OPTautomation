package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 1/9/2018.
 */
public class HCPConfirmationPage extends BasePageObject<HCPConfirmationPage> {
    private By confirmationText = By.cssSelector(".confirm-text>p");
    private By returnHomeButton = By.cssSelector(".button.-arrow");

    protected HCPConfirmationPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(confirmationText);
        waitForVisibilityOf(returnHomeButton);
        System.out.println("Page loaded !!");
    }

    public String getConfirmText(){
        return getText(confirmationText);
    }
}
