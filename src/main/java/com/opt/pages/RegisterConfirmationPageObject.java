package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class RegisterConfirmationPageObject extends BasePageObject<RegisterConfirmationPageObject> {

    private By confirmationMsg = By.cssSelector(".success-msg>ul>li>span");
    private By successBlock = By.cssSelector(".success-content");
    private By header = By.cssSelector("h1");

    protected RegisterConfirmationPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public String getHeaderText(){
        return getText(header);
    }

    public String getMessageText(){
        return getText(confirmationMsg);
    }

    public void waitForConfirmationPage() throws InterruptedException{
        Thread.sleep(5000);
        waitForVisibilityOf(header);
    }

    public String getBlockText(){
        return getText(successBlock);
    }
}
