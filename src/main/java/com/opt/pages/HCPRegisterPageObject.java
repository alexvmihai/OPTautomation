package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by alex.mihai on 1/8/2018.
 */
public class HCPRegisterPageObject extends BasePageObject<HCPRegisterPageObject> {
    private By popUpAgree = By.cssSelector("#pop-yes-hcp-disclaimer");
    private By popUpText1 = By.cssSelector(".modal-content>p");
    private By popUpTitle = By.cssSelector(".modal-title");
    private By titleF = By.cssSelector("#hcp_title");
    private By firstNameF = By.cssSelector("#firstname");
    private By lastNameF = By.cssSelector("#lastname");
    private By emailF = By.cssSelector("#email");
    private By professionF = By.cssSelector("#profession");
    private By addressF = By.cssSelector("#street_1");
    private By suburbF = By.cssSelector("#city");
    private By countryF = By.cssSelector("#country_id");
    private By stateF = By.cssSelector("#region_id");
    private By postCodeF = By.cssSelector("#zip");
    private By phoneF = By.cssSelector("#telephone");
    private By agreementF = By.cssSelector("li.control:nth-child(3) > div:nth-child(1) > label:nth-child(2)");
    private By registerButtonF = By.cssSelector(".button.-arrow.right");




    public HCPRegisterPageObject (WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPopUp (){
        waitForVisibilityOf(popUpAgree);
        waitForVisibilityOf(popUpText1);
        waitForVisibilityOf(popUpTitle);
    }

    public boolean agreePopUp() throws InterruptedException {
        clickOn(popUpAgree);
        Thread.sleep(4000);
        if (!(driver.findElement(By.cssSelector("#pop-yes-hcp-disclaimer")).isDisplayed())){
            System.out.println("Disclaimer closed !");
            return true;
        }
        else{
            System.out.println("Disclaimer still present !");
            return false;
        }
    }

    public void fillInRegisterForm (String title, String firstname, String lastname, String email, String profession,
                                    String address, String suburb, String country, String state, String postcode, String phone){
        Select selectTitle = new Select(driver.findElement(By.cssSelector("#hcp_title")));
        selectTitle.selectByVisibleText(title);
        type(firstname, firstNameF);
        type(lastname, lastNameF);
        type(email, emailF);
        Select selectProfession = new Select(driver.findElement(By.cssSelector("#profession")));
        selectProfession.selectByVisibleText(profession);
        type(address, addressF);
        type(suburb, suburbF);
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#country_id")));
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.cssSelector("#region_id")));
        selectState.selectByVisibleText(state);
        type(postcode, postCodeF);
        type(phone, phoneF);
        clickOn(agreementF);
    }

    public HCPConfirmationPage submitForm() throws IOException {
        clickOn(registerButtonF);
        return new HCPConfirmationPage(driver);
    }







}
