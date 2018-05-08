package com.opt.pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.opt.base.BasePageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import sun.plugin2.message.JavaScriptBaseMessage;

import java.io.IOException;

/**
 * Created by alex.mihai on 9/22/2017.
 */
public class RegisterPageObject extends BasePageObject<RegisterPageObject> {
    private By becomeMember = By.cssSelector("h1.row");
    private By firstNameF = By.cssSelector("#gigya-textbox-50409164440432000");
//    private By firstNameF = By.cssSelector("#billing\\:firstname");
    private By lastNameF = By.cssSelector("#gigya-textbox-74737136494867060");
//    private By lastNameF = By.cssSelector("#billing\\:lastname");
    private By emailF = By.cssSelector("#gigya-loginID-148855513554729920");
//    private By emailF = By.cssSelector("#billing\\:email");
    private By addressF = By.cssSelector("#gigya-textbox-54127024532800910");
//    private By addressF = By.cssSelector("#billing\\:street1");
//    private By countryF = By.cssSelector("select[id=\"billing:country_id\"]");
    private By cityF = By.cssSelector("#gigya-textbox-75631261250994300");
//    private By cityF = By.cssSelector("#billing\\:city");
    private By postcodeF = By.cssSelector("#gigya-textbox-29964807112874270");
//    private By postcodeF = By.cssSelector("#billing\\:postcode");
    private By stateF = By.cssSelector("select[id=\"billing:region_id\"]");
    private By dayF = By.cssSelector("select[id=\"billing:day\"]");
    private By monthF = By.cssSelector("select[id=\"billing:month\"]");
    private By yearF = By.cssSelector("select[id=\"billing:year\"]");
    private By passwordF = By.cssSelector("#gigya-password-96723428394598540");
//    private By passwordF = By.cssSelector("#password");
    private By confirmPasswordF = By.cssSelector("#gigya-password-20946175269470924");
//    private By confirmPasswordF = By.cssSelector("#confirmation");
    private By termsF = By.cssSelector("#gigya-checkbox-27785807388893270 ");
//    private By termsF = By.cssSelector("li.control:nth-child(3) > div:nth-child(1) > label:nth-child(2)");
    private By completeF = By.cssSelector("#gigya-register-form > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)");
//    private By completeF = By.cssSelector("#onestepcheckout-place-order");
    private By leftBlock1F = By.cssSelector(".login-introduction");
    private By leftBlock2F = By.cssSelector(".account-box.-list.-faqs");
    private By duplicateMail = By.cssSelector(".gigya-error-code-400003");
//    private By duplicateMail = By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)");
//    private By duplicateMail = By.cssSelector("#onestepcheckout-email-error-message");
    private By date = By.cssSelector("#gigya-textbox-55856667791280660");
    private By dayOfMonth = By.cssSelector(".ui-datepicker-calendar > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(3) > a:nth-child(1)");



    protected RegisterPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForRegisterPageToLoad(){
        waitForVisibilityOf(becomeMember);
        waitForVisibilityOf(firstNameF);
        waitForVisibilityOf(leftBlock1F);
        waitForVisibilityOf(leftBlock2F);
        System.out.println("Register Page loaded succesfully !");
    }

    public void fillRegisterForm(String firstName, String lastName, String email, String address, String city, String postcode, String password, String passwordConfirm, String country, String state
                                 ) throws InterruptedException {
        System.out.println("Filling in the form...");
        type(firstName, firstNameF);
        type(lastName, lastNameF);
        type(email, emailF);
        type(address, addressF);
        type(city, cityF);
        type(postcode, postcodeF);
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-85978887874792580")));
//        Select selectCountry = new Select(driver.findElement(By.cssSelector("#billing\\:country_id")));

        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-141415150774347000")));
//        Select selectState = new Select(driver.findElement(By.cssSelector("#billing\\:region_id")));

        selectState.selectByVisibleText(state);
        Select selectDay = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-141415150774347000")));
//        Select selectDay = new Select(driver.findElement(By.cssSelector("#billing\\:day")));

        clickOn(date);
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('gigya-textbox-55856667791280660').value='1949-04-19';");
//        Select selectYear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
//        selectYear.selectByVisibleText(year);
//        clickOn(dayOfMonth);

//        Select selectMonth = new Select(driver.findElement(By.cssSelector("#billing\\:month")));

//        selectMonth.selectByVisibleText(month);
//        Select selectYear = new Select(driver.findElement(By.cssSelector("#gigya-dropdown-149542757656976770")));
////        Select selectYear = new Select(driver.findElement(By.cssSelector("#billing\\:year")));
        type(password, passwordF);
        type(passwordConfirm, confirmPasswordF);



    }

    public void agreeTerms(){
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,800)");
        WebElement terms = driver.findElement(By.cssSelector("#gigya-checkbox-27785807388893270"));
        terms.sendKeys(Keys.SPACE);
        System.out.println("Terms and conditions agreed.");
    }

    public RegisterConfirmationPageObject submitForm() throws IOException {
        System.out.println("Submitting form...");
        clickOn(completeF);
        return new RegisterConfirmationPageObject(driver);
    }

    public String getDuplicateEmailMsg(){
        return getText(duplicateMail);
    }






}


