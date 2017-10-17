package com.opt.base;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex.mihai on 6/26/2017.
 */

public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;


    protected BasePageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    protected T getPage(String url){
        driver.get(url);
        return (T) this;
    }

    public boolean isAlertPresent(){
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException Ex){
            return false;
        }
    }
    public void acceptPrompt() throws InterruptedException {
        if (isAlertPresent()){
            driver.switchTo().alert().accept();
        }
        Thread.sleep(6000);
    }

    protected void type(String text, By element){
        find(element).sendKeys(text);
    }

    protected void deleteText(By element){
        find(element).clear();
    }

    protected void clickOn (By element){
        find(element).click();
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void waitForVisibilityOf (By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while (attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length >0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e){
            }
            attempts++;
        }
    }

    private void waitFor (ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    protected String getText(By element) {
        return find(element).getText();
    }

    public String getSource(){
        return driver.getPageSource();
    }

    public String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEEEE d MMMMMMMM");
        return formatter.format(date);
    }

    public void mouseOver(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }





}

