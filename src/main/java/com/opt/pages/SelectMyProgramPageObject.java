package com.opt.pages;

import com.opt.base.BasePageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex.mihai on 11/9/2017.
 */
public class SelectMyProgramPageObject extends BasePageObject<SelectMyProgramPageObject>{
    private By header = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/h2");
    private By schedule = By.xpath("html/body/div[2]/div[2]/div/div/div[3]");
    //3x Optifast
    private By intensiveColumn = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/thead/tr[2]/th[2]");
    private By veryActive1 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[2]/td[2]");
    private By active1 = By.cssSelector("#\\31 -2");
    private By lightlyActive1 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[4]/td[2]");
    //2x Optifast
    private By active2Column = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/thead/tr[2]/th[3]");
    private By veryActive2 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[2]/td[3]");
    private By active2 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[3]/td[3]");
    private By lightlyActive2 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[4]/td[3]");
    //1x Optifast
    private By active1Column = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/thead/tr[2]/th[4]");
    private By veryActive3 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[2]/td[4]");
    private By active3 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[3]/td[4]");
    private By lightlyActive3 = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[1]/div/div[1]/table/tbody/tr[4]/td[4]");

    private By trajectory = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[2]/div[1]/div[1]/div/div/svg/rect");
    private By estimated = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[2]/div[1]/div[2]");
    private By setPreferences = By.xpath("html/body/div[2]/div[2]/div/div/div[3]/form/div[2]/div[2]/button[3]");





    protected SelectMyProgramPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
        waitForVisibilityOf(schedule);
        waitForVisibilityOf(intensiveColumn);
    }

    public void selectActive1() throws InterruptedException {
        WebElement exercise = driver.findElement(By.cssSelector("#\\31 -2"));
        Actions mouseover = new Actions(driver);
        mouseover.moveToElement(exercise).build().perform();
        clickOn(active1);
        Thread.sleep(9000);
    }

    public void selectVeryActive1() throws InterruptedException {
        clickOn(veryActive1);
        clickOn(veryActive1);
        Thread.sleep(9000);
    }

    public void selectLightlyActive1() throws InterruptedException {
        clickOn(lightlyActive1);
        clickOn(lightlyActive1);
        Thread.sleep(9000);
    }

    public void selectActive2() throws InterruptedException {
        clickOn(active2);
        clickOn(active2);
        Thread.sleep(9000);
    }

    public void selectVeryActive2() throws InterruptedException {
        clickOn(veryActive2);
        clickOn(veryActive2);
        Thread.sleep(9000);
    }

    public void selectLightlyActive2() throws InterruptedException {
        clickOn(lightlyActive2);
        clickOn(lightlyActive2);
        Thread.sleep(9000);
    }

    public void selectActive3() throws InterruptedException {
        clickOn(active3);
        clickOn(active3);
        Thread.sleep(9000);
    }

    public void selectVeryActive3() throws InterruptedException {
        clickOn(veryActive3);
        clickOn(veryActive3);
        Thread.sleep(9000);
    }

    public void selectLightlyActive3() throws InterruptedException {
        clickOn(lightlyActive3);
        clickOn(lightlyActive3);
        Thread.sleep(9000);
    }

    public void waitForTrajectoryToLoad(){
        waitForVisibilityOf(estimated);
        System.out.println("Trajectory Loaded !");
    }

    public String getActive1Text(){
        return getText(active1);
    }

    public String parsedActive1Text(){
        String full = getActive1Text();
//        String[] array = full.split("");
//        String parsed = array[26] + array[27] + array[28] + array[29] + array[30] + array[31] + array[32] + array[33] + array[34];
        String parsed = full.substring(full.length() -8);
        return parsed;
    }

    public String getEstimatedText(){
        return getText(estimated);
    }

    public String parsedEstimatedText(){
        String full = getEstimatedText();
        String parsed = full.substring(full.length() -8);
        return parsed;
    }

    public MyPreferencesPageObject setPreferences() throws IOException {
        System.out.println("Setting preferences...");
        clickOn(setPreferences);
        return new MyPreferencesPageObject(driver);
    }

}
