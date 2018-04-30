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
//    private By titleF = By.cssSelector("#hcp_title");
    private By titleF = By.cssSelector("#gigya-dropdown-85640842986684140");
//    private By firstNameF = By.cssSelector("#firstname");
    private By firstNameF = By.cssSelector("#gigya-textbox-50409164440432000");
//    private By lastNameF = By.cssSelector("#lastname");
    private By lastNameF = By.cssSelector("#gigya-textbox-74737136494867060");
//    private By emailF = By.cssSelector("#email");
    private By emailF = By.cssSelector("#gigya-loginID-148855513554729920");
//    private By professionF = By.cssSelector("#profession");
    private By professionF = By.cssSelector("#gigya-dropdown-101984559795693000");
//    private By addressF = By.cssSelector("#street_1");
    private By addressF = By.cssSelector("#gigya-textbox-54127024532800910");
//    private By suburbF = By.cssSelector("#city");
    private By suburbF = By.cssSelector("#gigya-textbox-75631261250994300");
//    private By countryF = By.cssSelector("#country_id");
    private By countryF = By.cssSelector("#gigya-dropdown-85978887874792580");
//    private By stateF = By.cssSelector("#region_id");
    private By stateF = By.cssSelector("#gigya-textbox-75631261250994300");
//    private By postCodeF = By.cssSelector("#zip");
    private By postCodeF = By.cssSelector("#gigya-textbox-29964807112874270");
//    private By phoneF = By.cssSelector("#telephone");
    private By phoneF = By.cssSelector("#gigya-textbox-96403577394262380");
//    private By agreementF = By.cssSelector("li.control:nth-child(3) > div:nth-child(1) > label:nth-child(2)");
    private By agreementF = By.cssSelector("#gigya-register-form > div:nth-child(1) > div:nth-child(24) > label:nth-child(2) > span:nth-child(1)");
//    private By registerButtonF = By.cssSelector(".button.-arrow.right");
    private By registerButtonF = By.cssSelector("#gigya-register-form > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
    private By checkboxAccreditation = By.cssSelector("#gigya-register-form > div:nth-child(1) > div:nth-child(25) > label:nth-child(2) > span:nth-child(1)");
    private By checkboxNestle = By.cssSelector("#gigya-register-form > div:nth-child(1) > div:nth-child(26) > label:nth-child(2) > span:nth-child(1)");
    private By passwordF = By.cssSelector("#gigya-password-96723428394598540");
    private By passwordConfF = By.cssSelector("#gigya-password-20946175269470924");


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
                                    String address, String suburb, String country, String city, String state, String postcode, String phone, String password){
        Select selectTitle = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-85640842986684140")));
        selectTitle.selectByVisibleText(title);
        type(firstname, firstNameF);
        type(lastname, lastNameF);
        type(email, emailF);
        Select selectProfession = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-101984559795693000")));
        selectProfession.selectByVisibleText(profession);
        type(address, addressF);
        type(suburb, suburbF);
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-85978887874792580")));
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-141415150774347000")));
        selectState.selectByVisibleText(state);
        type(city, stateF);
        type(postcode, postCodeF);
        type(phone, phoneF);
        clickOn(agreementF);
        clickOn(checkboxAccreditation);
        clickOn(checkboxNestle);
        type(password, passwordF);
        type(password, passwordConfF);
    }

    public HCPConfirmationPage submitForm() throws IOException, InterruptedException {
        Thread.sleep(3000);
        clickOn(registerButtonF);
        return new HCPConfirmationPage(driver);
    }







}
