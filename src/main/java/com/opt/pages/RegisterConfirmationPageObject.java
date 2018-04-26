package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class RegisterConfirmationPageObject extends BasePageObject<RegisterConfirmationPageObject> {

//    private By confirmationMsg = By.cssSelector(".success-msg>ul>li>span");
    private By confirmationMsg = By.cssSelector("#gigya-resend-verification-code-form > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)");
    private By successBlock = By.cssSelector("#gigya-resend-verification-code-form > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)");
//    private By header = By.cssSelector("h1");
    private By header = By.cssSelector("#onestepcheckout-form-container_content_caption");

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
