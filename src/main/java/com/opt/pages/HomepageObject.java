package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class HomepageObject extends BasePageObject<HomepageObject> {
    private String prodURL = "https://www.optifast.com.au/";
    private By optifastHeader = By.xpath("html/body/div[2]/div[1]/div/h1");
    private By joinNow = By.cssSelector("a[title=\"Join Now\"]");
    private By termsAndConditions = By.xpath("html/body/div[2]/footer/div[1]/ul/li[2]/a[2]");
    private String url = getURL("D:\\Access Credentials\\opt_url.txt", "url");
    private By HCP = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/a");
    private By HCPRegister = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/ul/li[6]/a");

    public HomepageObject(WebDriver driver) throws IOException {
        super(driver);
    }


    public void openHomePage(){
        getPage(url);
    }

    public void waitForHomepageToLoad(){
        waitForVisibilityOf(optifastHeader);
    }

    public RegisterPageObject clickJoinNow(){
        clickOn(joinNow);
        return new RegisterPageObject(driver);
    }

    public TermsAndConditionsPageObject openTermsAndConditions(){
        System.out.println("Clicking on terms and conditions....");
        clickOn(termsAndConditions);
        return new TermsAndConditionsPageObject(driver);
    }

    public HCPRegisterPageObject openHCPRegisterPage() throws InterruptedException {
        mouseOver(driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/a")));
        Thread.sleep(3000);
        clickOn(HCPRegister);
        return new HCPRegisterPageObject(driver);
    }
}
