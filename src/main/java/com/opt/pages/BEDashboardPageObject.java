package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class BEDashboardPageObject extends BasePageObject<BEDashboardPageObject> {
    private By header = By.cssSelector(".head-dashboard");
    private By popUp = By.cssSelector(".message-popup-head > a:nth-child(1) > span:nth-child(1)");
    private By customers = By.xpath("html/body/div[1]/div[1]/div[3]/ul/li[4]/a/span");
    private By manageCustomers = By.xpath("html/body/div[1]/div[1]/div[3]/ul/li[4]/ul/li[1]/a/span");
    private By HCPRegistrationRequests = By.cssSelector("li.level0:nth-child(8) > ul:nth-child(2) > li:nth-child(7) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)");


    protected BEDashboardPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void closePopUp() throws InterruptedException {
        Thread.sleep(4000);
        clickOn(popUp);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
    }

    public void clickCustomers() throws InterruptedException {
        clickOn(customers);
        Thread.sleep(5000);
        System.out.println("Clicked on customers");

    }

    public void mouseOverCustomers(){
        WebElement element = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[3]/ul/li[4]/a/span"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public BEManageCustomersPageObject clickManage() throws InterruptedException, IOException {
        System.out.println("Clicking on Manage Customers...");
        Thread.sleep(5000);
        clickOn(manageCustomers);
        return new BEManageCustomersPageObject(driver);
    }

    public void mouseOverEwave() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("li.level0:nth-child(8) > a:nth-child(1) > span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
    }

    public void mouseOverHCP() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("li.level0:nth-child(8) > ul:nth-child(2) > li:nth-child(7) > a:nth-child(1) > span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(2000);
    }

    public HCPRegistrationRequestsPageObject clickHCPRequests() throws IOException, InterruptedException {
//        Thread.sleep(3000);
        clickOn(HCPRegistrationRequests);
        return new HCPRegistrationRequestsPageObject(driver);
    }


}
