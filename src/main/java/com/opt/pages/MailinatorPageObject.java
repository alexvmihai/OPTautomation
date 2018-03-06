package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class MailinatorPageObject extends BasePageObject<MailinatorPageObject> {
    private String url = "https://www.mailinator.com/";
    private By inboxF = By.cssSelector("input[id=\"inboxfield\"]");
    private By goButton = By.cssSelector(".btn.btn-dark");
    private By activateMail = By.cssSelector("div.all_message-min_autor:nth-child(3)");
    private By clickToActivate = By.xpath("html/body/div[1]/table/tbody/tr/td/table/tbody/tr[5]/td/span/a");
    private By resetPass = By.xpath("html/body/div[1]/table/tbody/tr/td/table/tbody/tr[3]/td/span/span/a");



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

    public void clickGo() throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("Clicking on Go ....");
        clickOn(goButton);
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    public LoginPageObject clickToActivate() throws InterruptedException, IOException {
//        System.out.println("Waiting for the emails to be received...");
//        Thread.sleep(180000);
        clickOn(activateMail);
        Thread.sleep(4000);
        driver.switchTo().frame("msg_body");
        clickOn(clickToActivate);
        driver.switchTo().defaultContent();
        System.out.println("Account activated !");
        return new LoginPageObject(driver);
    }

    public ResetPasswordPageObject resetPass() throws InterruptedException {
        clickOn(activateMail);
        Thread.sleep(4000);
        driver.switchTo().frame("msg_body");
        clickOn(resetPass);
        driver.switchTo().defaultContent();
        System.out.println("Going to Password reset page...");
        return new ResetPasswordPageObject(driver);

    }
}
