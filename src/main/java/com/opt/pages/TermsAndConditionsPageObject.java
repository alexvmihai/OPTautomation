package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

/**
 * Created by alex.mihai on 11/6/2017.
 */
public class TermsAndConditionsPageObject extends BasePageObject<TermsAndConditionsPageObject> {
    //Member Terms and Conditions
    private By membersH = By.xpath("html/body/div[2]/div[2]/div/div/p[1]/b");
    private By membersP1 = By.xpath("html/body/div[2]/div[2]/div/div/p[2]");
    private By membersP2 = By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[1]");
    private By membersP3 = By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[2]");
    private By membersP4 = By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[3]");
    private By membersP5 = By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[4]");
    //Rules of Engagement
    private By engagementH = By.cssSelector(".block > p:nth-child(5) > b:nth-child(1)");
    private By engagementP1 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[1]");
    private By engagementP2 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[2]");
    private By engagementP3 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[3]");
    private By engagementP4 = By.cssSelector(".block > ul:nth-child(7) > li:nth-child(4)");
    private By engagementP5 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[5]");
    private By engagementP6 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[6]");
    private By engagementP7 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[7]");
    private By engagementP8 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[8]");
    private By engagementP9 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[9]");
    private By engagementP10 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[10]");
    private By engagementP11 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[11]");
    private By engagementP12 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[12]");
    private By engagementP13 = By.xpath("html/body/div[2]/div[2]/div/div/ul[2]/li[13]");
    private By engagementP14 = By.cssSelector(".block > p:nth-child(6)");

    By[] arrayMemberElem = {membersP1, membersP2, membersP3, membersP4, membersP5};
    By[] arrayEngagementElem = {engagementP14, engagementP1, engagementP2, engagementP3, engagementP4, engagementP5, engagementP6, engagementP7,
                                engagementP8, engagementP9, engagementP10, engagementP11, engagementP12, engagementP13};

    protected TermsAndConditionsPageObject(WebDriver driver) {
        super(driver);
    }

    public String getCurrentPageTitle(){
        return getTitle();
    }

    public String[] buildArrayMemberText(){
        String[] arrayText = new String[5];
        for (int i = 0; i < arrayMemberElem.length; i++){
            arrayText[i] = getText(arrayMemberElem[i]);
        }
        System.out.println(Arrays.toString(arrayText));
        return arrayText;
    }

    public String[] buildArrayEngagementText(){
        String[] arrayText = new String[14];
        for (int i = 0; i < arrayEngagementElem.length; i++){
            arrayText[i] = getText(arrayEngagementElem[i]);
        }
        System.out.println(Arrays.toString(arrayText));
        return arrayText;
    }


    public void waitForPageToLoad(){
        waitForVisibilityOf(engagementH);
        waitForVisibilityOf(membersH);
        System.out.println("Terms and conditions page loaded !");
    }


}
