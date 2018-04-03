package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 1/9/2018.
 */
public class HCPRegistrationRequestsPageObject extends BasePageObject<HCPRegistrationRequestsPageObject> {
    private By emailF = By.cssSelector("#hcpRequestsGrid_filter_email");
    private By header = By.cssSelector(".icon-head.head-adminhtml-requests");
    private By searchButton = By.cssSelector("button[title=\"Search\"]");
    private By message = By.cssSelector(".success-msg>ul>li>span");

    protected HCPRegistrationRequestsPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(emailF);
        waitForVisibilityOf(header);
        waitForVisibilityOf(searchButton);
    }

    public void searchEmail(String email) throws InterruptedException {
        type(email, emailF);
        clickOn(searchButton);
        Thread.sleep(8000);
    }

    public void accredit(){
        driver.findElement(By.partialLinkText("Mark")).click();
    }

    public void waitForMessage(){
        waitForVisibilityOf(message);
    }

    public String getMessage(){
        return getText(message);
    }
}
