package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 6/26/2017.
 */
public class HomepageObject extends BasePageObject<HomepageObject> {
    private String prodURL = "https://www.optifast.com.au/";
    private By optifastHeader = By.xpath("html/body/div[2]/div[1]/div/h1");
    private By joinNow = By.cssSelector("a[title=\"Join Now\"]");
    private By termsAndConditions = By.cssSelector("ul.links:nth-child(2) > li:nth-child(2) > a:nth-child(1)");
    private String url = BaseURL();
    private By HCP = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/a");
    private By HCPRegister = By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/ul/li[6]/a");
    private By loginButton = By.cssSelector(".user-login > a:nth-child(1)");
    protected JavascriptExecutor executor = (JavascriptExecutor)driver;

    public HomepageObject(WebDriver driver) throws IOException {
        super(driver);
    }


    public void openHomePage(){
        getPage(url);
    }

    public void waitForHomepageToLoad(){
        waitForVisibilityOf(optifastHeader);
    }

    public RegisterPageObject clickJoinNow() throws IOException {
        clickOn(joinNow);
        return new RegisterPageObject(driver);
    }

    public TermsAndConditionsPageObject openTermsAndConditions() throws IOException {
        executor.executeScript("javascript:window.scrollBy(0,2000)");
        System.out.println("Clicking on terms and conditions....");
        clickOn(termsAndConditions);
        return new TermsAndConditionsPageObject(driver);
    }

    public HCPRegisterPageObject openHCPRegisterPage() throws InterruptedException, IOException {
        mouseOver(driver.findElement(By.xpath("html/body/div[2]/header/div[2]/div/ul/li[4]/a")));
        Thread.sleep(3000);
        clickOn(HCPRegister);
        return new HCPRegisterPageObject(driver);
    }

    public LoginPageObject openLogin() throws IOException {
        clickOn(loginButton);
        return new LoginPageObject(driver);
    }
}
