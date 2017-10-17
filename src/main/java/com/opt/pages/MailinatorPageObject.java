package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class MailinatorPageObject extends BasePageObject<MailinatorPageObject> {
    private String url = "https://www.mailinator.com/";
    private By inboxF = By.cssSelector("input[id=\"inboxfield\"]");
    private By goButton = By.cssSelector(".btn.btn-dark");
    private By activateMail = By.cssSelector("#inboxpane li:nth-child(1) div:nth-child(1) div:nth-child(3)");
    private By clickToActivate = By.xpath("html/body/div[1]/table/tbody/tr/td/table/tbody/tr[5]/td/span/a");



    public MailinatorPageObject(WebDriver driver) {
        super(driver);
    }

    public void openMailinator(){
        System.out.println("Opening homepage...");
        getPage(url);
    }

    public void waitForHomepageToLoad(){
        waitForVisibilityOf(inboxF);
    }

    public void submitEmail(String email){
        System.out.println("Submitting email...");
        type(email, inboxF);
    }

    public void clickGo(){
        clickOn(goButton);
    }

    public LoginPageObject clickToActivate() throws InterruptedException {
        clickOn(activateMail);
        Thread.sleep(4000);
        driver.switchTo().frame("msg_body");
        clickOn(clickToActivate);
        driver.switchTo().defaultContent();
        System.out.println("Account activated !");
        return new LoginPageObject(driver);
    }
}
