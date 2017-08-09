package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class HomepageObject extends BasePageObject<HomepageObject> {
    private String homePageURL ="https://optaros:opt1234@preprod.optifast.com.au/";
    private By optifastHeader = By.xpath("html/body/div[2]/div[1]/div/h1");
    public HomepageObject(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(){
        getPage(homePageURL);
    }
    public void waitForHomepageToLoad(){
        waitForVisibilityOf(optifastHeader);
    }
}
