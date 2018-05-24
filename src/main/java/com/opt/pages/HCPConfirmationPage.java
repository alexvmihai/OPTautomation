package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 1/9/2018.
 */
public class HCPConfirmationPage extends BasePageObject<HCPConfirmationPage> {
//    private By confirmationText = By.cssSelector(".confirm-text>p");
    private By returnHomeButton = By.cssSelector(".button.-arrow");
    private By confirmationText = By.cssSelector("#gigya-resend-verification-code-form > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)");
    private By header = By.cssSelector("#gigya-resend-verification-code-form > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)");

    protected HCPConfirmationPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(confirmationText);
//        waitForVisibilityOf(returnHomeButton);
        waitForVisibilityOf(header);
        System.out.println("Page loaded !!");
    }

    public String getConfirmText(){
        return getText(confirmationText);
    }
}
