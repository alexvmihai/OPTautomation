package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 11/8/2017.
 */
public class AboutMePageObject extends BasePageObject<AboutMePageObject> {
    private By aboutMeHeader = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/h2");
    private By dayF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[2]/div/div[1]/select");
    private By monthF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[2]/div/div[2]/select");
    private By yearF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[2]/div/div[3]/select");
    private By maleF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[3]/div/div/label[1]");
    private By femaleF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[3]/div/div/label[2]");
    private By heightF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[5]/div/input[2]");
    private By weightF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[1]/ul/li[6]/div/input[2]");
    private By bmiF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[2]/div/div[2]/input");
    private By save = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[4]/button[1]");
    private By setGoal = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[4]/button[2]");

    //Medical Conditions
    private By pregnantF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[3]/div/div[2]/label[3]");
    private By diabetesF = By.xpath("html/body/div[2]/div[2]/div/div/div[1]/form/div[3]/div/div[2]/label[2]");

    private By proceedButton = By.xpath("html/body/div[8]/div[2]/div/button[2]");
    private By precautionButton = By.xpath("html/body/div[8]/div[2]/div/button[2]");


    public AboutMePageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(aboutMeHeader);
        waitForVisibilityOf(save);
        waitForVisibilityOf(bmiF);
    }

    public void setHeight(String height){
        driver.findElement(heightF).sendKeys(Keys.CONTROL, "a");
        type(height, heightF);
    }

    public void setWeight(String weight){
        driver.findElement(weightF).sendKeys(Keys.CONTROL, "a");
        type(weight, weightF);
    }

    public void setMale(){
        clickOn(maleF);
    }

    public void setFemale(){
        clickOn(femaleF);
    }

    public void setMyGoal() throws InterruptedException {
        System.out.println("Proceeding to My Goal section.");
        clickOn(setGoal);
        Thread.sleep(4000);
    }

    public String getBMI(){
        return getText(bmiF);
    }

    public void setMedicalConditions() throws InterruptedException {
        clickOn(diabetesF);
        clickOn(pregnantF);
        Thread.sleep(5000);
    }

    public MyGoalPageObject acceptRecommendation() throws InterruptedException {
        System.out.println("Accepting recommendation...");
        clickOn(proceedButton);
        Thread.sleep(4000);
        return new MyGoalPageObject(driver);
    }

    public void acceptPrecaution(){
        System.out.println("Accepting precaution...");
        clickOn(precautionButton);
    }

}
