package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class MailinatorPageObject extends BasePageObject<MailinatorPageObject> {
    private String url = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private By header = By.cssSelector("#headingText");
    private By goButton = By.cssSelector(".btn.btn-dark");
    private By emailSubject = By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]/b");
    private By clickToActivate = By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[2]/div[3]/table/tbody/tr/td/table/tbody/tr[5]/td/span/a/span");

    private By resetPass = By.cssSelector("body > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)");
    private By emailF = By.cssSelector("#identifierId");
    private By next1B = By.cssSelector("#identifierNext > content:nth-child(3) > span:nth-child(1)");
    private By passwordF = By.cssSelector("#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    private By next2B = By.cssSelector("#passwordNext > content:nth-child(3) > span:nth-child(1)");
    private By doneB = By.cssSelector(".yKBrKe > div:nth-child(1) > content:nth-child(3)");
    private By composeB = By.cssSelector(".T-I-KE");
    private By gmailHeader = By.cssSelector("#\\:i > span:nth-child(1)");




    public MailinatorPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void openMailinator(){
        System.out.println("Opening homepage...");
        getPage(url);
    }

    public void waitForHomepageToLoad(){
        waitForVisibilityOf(header);
    }

    public void submitEmail() throws IOException {
        System.out.println("Submitting email...");
        waitForVisibilityOf(emailF);
        String[] credentials = getMemberCredentials("D:\\Access Credentials\\opt_login.txt");
        type(credentials[0], emailF);
        clickOn(next1B);
        waitForVisibilityOf(passwordF);
        type(credentials[1], passwordF);
        clickOn(next2B);
    }

    public void submitHCPEmail() throws IOException {
        String[] credentials = getHCPredentials("D:\\Access Credentials\\opt_login.txt");
        waitForVisibilityOf(emailF);
        type(credentials[0], emailF);
        clickOn(next1B);
        waitForVisibilityOf(passwordF);
        type(credentials[1], passwordF);
        clickOn(next2B);
    }

//    public void clickGo() throws InterruptedException{
//        Thread.sleep(5000);
//        System.out.println("Clicking on Go ....");
//        clickOn(goButton);
//        Thread.sleep(6000);
//        if (isAlertPresent()) {
//            driver.switchTo().alert().accept();
//        }
//        Thread.sleep(3000);
//    }

    public CreateProgramPageObject clickToActivate() throws InterruptedException, IOException {
//        System.out.println("Waiting for the emails to be received...");
//        Thread.sleep(180000);
        waitForVisibilityOf(composeB);
        waitForVisibilityOf(gmailHeader);
        clickOn(emailSubject);
        Thread.sleep(4000);
//        driver.switchTo().frame("msg_body");
        clickOn(clickToActivate);
//        driver.switchTo().defaultContent();
        System.out.println("Account activated !");
        return new CreateProgramPageObject(driver);
    }



    public HCPDashboardPageObject resetPass() throws InterruptedException, IOException {
        clickOn(emailSubject);
        Thread.sleep(4000);
        driver.switchTo().frame("msg_body");
        clickOn(resetPass);
        driver.switchTo().defaultContent();
        System.out.println("Going to Password reset page...");
        return new HCPDashboardPageObject (driver);

    }
}
