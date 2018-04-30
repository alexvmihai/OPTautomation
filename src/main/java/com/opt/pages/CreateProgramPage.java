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
public class CreateProgramPage extends BasePageObject<CreateProgramPage>{
    private By forum = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/span");
    private By communityForum = By.cssSelector("li.menu-item:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)");

    public CreateProgramPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public ForumSetupPageObject openForum () throws InterruptedException, IOException {
        Thread.sleep(4000);
        System.out.println("Clicking on Forum & Support Tools ...");
        WebElement exercise = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[3]/span"));
        Actions mouseover = new Actions(driver);
        mouseover.moveToElement(exercise).build().perform();
        WebElement element = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[5]/span"));
        Actions mouseover2 = new Actions(driver);
        mouseover2.moveToElement(element).build().perform();
        Thread.sleep(3000);
        clickOn(communityForum);
        return new ForumSetupPageObject(driver);
    }

    public void waitForForumButtonToLoad(){
        waitForVisibilityOf(forum);
    }
}
