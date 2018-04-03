package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/17/2017.
 */
public class ForumPageObject extends BasePageObject<ForumPageObject> {
    private By forumHeader = By.xpath("html/body/div[2]/div[1]/div[1]/h1");
    private By technicalAssistance = By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/a");
    private By welcome = By.xpath("html/body/div[2]/div[1]/div[2]/span");
    private By recentTopics = By.xpath("html/body/div[2]/div[2]/div[1]/ul/li[2]/a");
    private By newTopic = By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div/div[1]/a");
    private By titleF = By.xpath("html/body/div[2]/div[2]/div[2]/form/div[1]/ul/li[1]/div/input");
//    private By descriptionF = By.xpath("html/body/p");
    private By descriptionF = By.xpath("//*[@id='tinymce']/p[1]");
    private By iframe = By.cssSelector("#Post_ifr");
    private By emoticon = By.xpath("html/body/div[2]/div[2]/div[2]/form/div[1]/ul/li[3]/div/div[1]/div/div[1]/div/div/div/div[3]/div/div[1]/button");
    private By smiley = By.xpath("//div[@id='mceu_14']/table/tbody/tr[2]/td[3]/a/img");
    private By saveButton = By.xpath("html/body/div[2]/div[2]/div[2]/form/div[2]/button");
    private By replyButton = By.xpath("html/body/div[2]/div[2]/div[2]/div[3]/div/div[1]/a");
    private By postText = By.xpath("html/body/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/p");
    private By postHeader = By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/h4");


    protected ForumPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void clickHelpTopic(){
        clickOn(technicalAssistance);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(forumHeader);
        waitForVisibilityOf(welcome);
    }

    public void waitForNewTopicPageToLoad(){
        waitForVisibilityOf(titleF);
        waitForVisibilityOf(iframe);
    }

    public void clickNewTopic(){
        clickOn(newTopic);
    }

    public void switchFrame(){
        driver.switchTo().frame(driver.findElement(By.cssSelector("#Post_ifr")));
    }

    public void typeDescription() throws InterruptedException {
        clickOn(emoticon);
        Thread.sleep(1500);
        clickOn(smiley);
        Thread.sleep(3000);
        System.out.println("Description was uploaded !");
    }

    public void typeTitle(String title){
        type(title, titleF);
    }

    public void submitPost(){
        System.out.println("Submitting post...");
        clickOn(saveButton);
    }

    public void replyPost(){
        System.out.println("Replying post..");
        clickOn(replyButton);
    }

    public String getPostHeaderText(){
        return getText(postHeader);
    }



}
