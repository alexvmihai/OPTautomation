package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/2/2017.
 */
public class BEHomePageObject extends BasePageObject<BEHomePageObject> {
    private By userNameF = By.cssSelector("#username");
    private By passwordF = By.cssSelector("#login");
    private By loginButton = By.cssSelector(".form-button");
    private String url = getURL("D:\\Access Credentials\\opt_url.txt", "url_admin");

    public BEHomePageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(userNameF);
        waitForVisibilityOf(passwordF);
    }

    public void openHomepage(){
        getPage(url);
    }

    public void fillCredentials(String username, String password){
        System.out.println("Filling in credentials...");
        type(username, userNameF);
        type(password, passwordF);
    }

    public BEDashboardPageObject clickLogin(){
        clickOn(loginButton);
        return new BEDashboardPageObject(driver);
    }
}
