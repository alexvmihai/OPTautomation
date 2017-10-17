package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by alex.mihai on 9/22/2017.
 */
public class RegisterPageObject extends BasePageObject<RegisterPageObject> {
    private By becomeMember = By.cssSelector("h1");
    private By firstNameF = By.cssSelector("input[id=\"billing:firstname\"]");
    private By lastNameF = By.cssSelector("input[id=\"billing:lastname\"]");
    private By emailF = By.cssSelector("input[id=\"billing:email\"]");
    private By addressF = By.cssSelector("input[id=\"billing:street1\"]");
    private By countryF = By.cssSelector("select[id=\"billing:country_id\"]");
    private By cityF = By.cssSelector("input[id=\"billing:city\"]");
    private By postcodeF = By.cssSelector("input[id=\"billing:postcode\"]");
    private By stateF = By.cssSelector("select[id=\"billing:region_id\"]");
    private By dayF = By.cssSelector("select[id=\"billing:day\"]");
    private By monthF = By.cssSelector("select[id=\"billing:month\"]");
    private By yearF = By.cssSelector("select[id=\"billing:year\"]");
    private By passwordF = By.cssSelector("input[id=\"password\"]");
    private By confirmPasswordF = By.cssSelector("input[id=\"confirmation\"]");
    private By termsF = By.cssSelector("label[for=\"agreement\"]");
    private By completeF = By.cssSelector("button[id=\"onestepcheckout-place-order\"]");
    private By leftBlock1F = By.cssSelector(".login-introduction");
    private By leftBlock2F = By.cssSelector(".account-box.-list.-faqs");


    protected RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForRegisterPageToLoad(){
        waitForVisibilityOf(becomeMember);
        waitForVisibilityOf(firstNameF);
        waitForVisibilityOf(leftBlock1F);
        waitForVisibilityOf(leftBlock2F);
        System.out.println("Register Page loaded succesfully !");
    }

    public void fillRegisterForm(String firstName, String lastName, String email, String address, String city, String postcode, String password, String passwordConfirm, String state,
                                 String day, String month, String year){
        System.out.println("Filling in the form...");
        type(firstName, firstNameF);
        type(lastName, lastNameF);
        type(email, emailF);
        type(address, addressF);
        type(city, cityF);
        type(postcode, postcodeF);
        type(password, passwordF);
        type(passwordConfirm, confirmPasswordF);
        Select selectState = new Select(driver.findElement(By.xpath(".//*[@id='billing:region_id']")));
        selectState.selectByVisibleText(state);
        Select selectDay = new Select(driver.findElement(By.xpath(".//*[@id='billing:day']")));
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(driver.findElement(By.xpath(".//*[@id='billing:month']")));
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(driver.findElement(By.xpath(".//*[@id='billing:year']")));
        selectYear.selectByVisibleText(year);


    }

    public void agreeTerms(){
        clickOn(termsF);
        System.out.println("Terms and conditions agreed.");
    }

    public RegisterConfirmationPageObject submitForm(){
        System.out.println("Submitting form...");
        clickOn(completeF);
        return new RegisterConfirmationPageObject(driver);
    }




}


