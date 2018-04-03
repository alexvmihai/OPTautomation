package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/17/2017.
 */
public class ForumSetupPageObject extends BasePageObject<ForumSetupPageObject>{
    private By nicknameF = By.xpath("html/body/div[2]/div[2]/div/div[2]/form/ul/li[1]/div/input");
    private By signatureF = By.xpath("html/body/div[2]/div[2]/div/div[2]/form/ul/li[3]/div/textarea");
    private By submitButton = By.xpath("html/body/div[2]/div[2]/div/div[2]/form/div/button");
    private By instruction = By.xpath("html/body/div[2]/div[2]/ul/li/ul/li/span");
    private By forum = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/span");
    private By communityForum = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/ul/li[1]/a");
    private By dashboard = By.xpath("html/body/div[2]/header/div[1]/div[1]/ul/li[2]/a");

    protected ForumSetupPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForForumSetup(){
        waitForVisibilityOf(instruction);
        waitForVisibilityOf(submitButton);
        waitForVisibilityOf(nicknameF);
    }

    public void setupForumAccount(String nickname, String signature){
        System.out.println("Filling in details for forum account...");
        type(nickname, nicknameF);
        type(signature, signatureF);
    }

    public ForumPageObject submitAccountDetails() throws InterruptedException, IOException {
        clickOn(submitButton);
        Thread.sleep(10000);
        return new ForumPageObject(driver);
    }

    public String getMessage(){
        return getText(instruction);
    }

    public ForumPageObject openForum () throws InterruptedException, IOException {
        Thread.sleep(4000);
        System.out.println("Clicking on Forum & Support Tools ...");
        WebElement exercise = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[3]/span"));
        Actions mouseover = new Actions(driver);
        mouseover.moveToElement(exercise).build().perform();
        WebElement element = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/span"));
        Actions mouseover2 = new Actions(driver);
        mouseover2.moveToElement(element).build().perform();
        Thread.sleep(1000);
        clickOn(communityForum);
        return new ForumPageObject(driver);
    }
}
