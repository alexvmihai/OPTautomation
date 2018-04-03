package com.opt.pages;

import com.opt.base.BasePageObject;
import com.opt.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class LoginPageObject extends BasePageObject<LoginPageObject> {
    private By returningMembersHeader = By.xpath(".//*[@id='login-form']/div/div[2]/div/div/h2");
//    private By loginButton = By.cssSelector("#gigya-login-form > div:nth-child(2) > div:nth-child(3) > div:nth-child(5) > input:nth-child(1)");
    private By loginButton = By.cssSelector("#send2");
//    private By emailField = By.cssSelector("#gigya-login-form > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > input:nth-child(1)");
    private By emailField = By.cssSelector("#email");
//    private By passwordField = By.cssSelector("#gigya-login-form > div:nth-child(2) > div:nth-child(3) > div:nth-child(3) > input:nth-child(1)");
    private By passwordField = By.cssSelector("#pass");

//    private By errorMsg = By.cssSelector("div.gigya-error-code-403042:nth-child(1)");
    private By errorMsg = By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)");

    private By successMsgNewAccount = By.cssSelector(".success-msg>ul>li>span");
//    private String url = BaseURL() + "customer/account/login/";
    private String url = BaseURL();
    private By successMsgPasswordUpdated = By.cssSelector(".success-msg>ul>li>span");

    public LoginPageObject(WebDriver driver) throws IOException {
        super(driver);
    }
    public void openLoginPage(){
        getPage(url);
        System.out.println(url);
    }
    public void waitForLoginPageToLoad(){
        waitForVisibilityOf(emailField);
        waitForVisibilityOf(loginButton);
    }

    public void fillInCredentials(String username, String password){
        System.out.println("Filling in username and pass...");
        type(username, emailField);
        type(password, passwordField);
    }
    public AccountDashboardPageObject clickLoginButton() throws IOException {
        System.out.println("Clicking on login button...");
        clickOn(loginButton);
        return new AccountDashboardPageObject(driver);
    }

    public HCPDashboardPageObject clickLoginButtonHCP() throws IOException {
        System.out.println("Clicking on login button...");
        clickOn(loginButton);
        return new HCPDashboardPageObject(driver);
    }

    public CreateProgramPageObject clickLoginButtonNewAccount() throws IOException {
        System.out.println("Clicking on login button...");
        clickOn(loginButton);
        return new CreateProgramPageObject(driver);
    }
    public void waitForErrorMsgToLoad(){
        waitForVisibilityOf(errorMsg);
        System.out.println("Error msg visible !");
    }
    public String getErrorMessage(){
        return getText(errorMsg);
    }

    public String getSuccessMessageNewAccount(){
        return getText(successMsgNewAccount);
    }

    public void waitForPassMsgToLoad(){
        waitForVisibilityOf(successMsgPasswordUpdated);
    }

    public String getPassUpdatedText(){
        return getText(successMsgPasswordUpdated);
    }
}
