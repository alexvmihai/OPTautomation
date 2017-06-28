package com.optifast.pages;

import com.optifast.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class LoginPageObject extends BasePageObject<LoginPageObject> {
    private String URL = "https://optaros:opt1234@preprod.optifast.com.au/customer/account/login/";
    private By returningMembersHeader = By.xpath(".//*[@id='login-form']/div/div[2]/div/div/h2");
    private By loginButton = By.xpath(".//*[@id='send2']");
    private By emailField = By.xpath(".//*[@id='email']");
    private By passwordField = By.xpath(".//*[@id='pass']");
    private By errorMsg = By.xpath("html/body/div[2]/div[2]/ul/li/ul/li/span");
    public LoginPageObject(WebDriver driver) {
        super(driver);
    }
    public void openLoginPage(){
        getPage(URL);
    }
    public void waitForLoginPageToLoad(){
        waitForVisibilityOf(returningMembersHeader);
        waitForVisibilityOf(loginButton);
    }

    public void fillInCredentials(String username, String password){
        System.out.println("Filling in username and pass...");
        type(username, emailField);
        type(password, passwordField);
    }
    public AccountDashboardPageObject clickLoginButton(){
        System.out.println("Clicking on login button...");
        clickOn(loginButton);
        return new AccountDashboardPageObject(driver);
    }
    public void waitForErrorMsgToLoad(){
        waitForVisibilityOf(errorMsg);
        System.out.println("Error msg visible !");
    }
    public String getErrorMessage(){
        return getText(errorMsg);
    }
}
