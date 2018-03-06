package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class LoginPageObject extends BasePageObject<LoginPageObject> {
    private By returningMembersHeader = By.xpath(".//*[@id='login-form']/div/div[2]/div/div/h2");
    private By loginButton = By.xpath(".//*[@id='send2']");
    private By emailField = By.xpath(".//*[@id='email']");
    private By passwordField = By.xpath(".//*[@id='pass']");
    private By errorMsg = By.xpath("html/body/div[2]/div[2]/ul/li/ul/li/span");
    private By successMsgNewAccount = By.cssSelector(".success-msg>ul>li>span");
    private String url = getURL("D:\\Access Credentials\\opt_url.txt", "url_login");
    private By successMsgPasswordUpdated = By.cssSelector(".success-msg>ul>li>span");

    public LoginPageObject(WebDriver driver) throws IOException {
        super(driver);
    }
    public void openLoginPage(){
        getPage(url);
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

    public HCPDashboardPageObject clickLoginButtonHCP(){
        System.out.println("Clicking on login button...");
        clickOn(loginButton);
        return new HCPDashboardPageObject(driver);
    }

    public CreateProgramPageObject clickLoginButtonNewAccount(){
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
