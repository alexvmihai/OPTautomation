package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/10/2017.
 */
public class BECustomerInfoPageObject extends BasePageObject<BECustomerInfoPageObject> {
    private By header = By.cssSelector(".icon-head.head-customer");
    private By continueButton = By.cssSelector("button[title=\"Continue\"]");
    private By customerRoleF = By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[1]/td[2]/select");
    private By websiteF = By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/select");
    private By firstNameF = By.cssSelector("#_accountfirstname");
    private By lastNameF = By.cssSelector("#_accountlastname");
    private By emailAddressF = By.cssSelector("#_accountemail");
    private By visibleF = By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[12]/td[2]/select");
    private By membershipF = By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[15]/td[2]/select");
    private By dateF = By.cssSelector("#_accountdob");
    private By genderF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[18]/td[2]/select");
    private By pregnantF = By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[19]/td[2]/select");
    private By heightF = By.cssSelector("#_accountheight");
    private By weightF = By.cssSelector("#_accountweight");
    private By passwordF = By.cssSelector("#_accountpassword");
    private By addresses = By.cssSelector("#customer_info_tabs_addresses>span");
    //Address fields
    private By defaultBilling = By.cssSelector("#address_item_billing_item1");
    private By firstNameFadress = By.cssSelector("#_item1firstname");
    private By lastNameFadress = By.cssSelector("#_item1lastname");
    private By streetFa = By.cssSelector("#_item1street0");
    private By cityF = By.cssSelector("#_item1city");
    private By countryF = By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[9]/td[2]/select");
    private By stateF = By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[10]/td[2]/select");
    private By zipcodeF = By.cssSelector("#_item1postcode");
    private By telephoneF = By.cssSelector("#_item1telephone");
    private By saveCustomer = By.cssSelector("button[title=\"Save Customer\"]"); ///save and continue edit



    protected BECustomerInfoPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void clickContinue() throws InterruptedException {
        clickOn(continueButton);
        Thread.sleep(9000);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
        waitForVisibilityOf(continueButton);
    }

    public void fillInCustomerDetails(String website, String firstName, String lastName, String email, String visible, String membership, String date, String gender, String pregnant, String height, String weight, String password){
        System.out.println("Filling in customer details...");
        Select selectWebsite = new Select(driver.findElement(By.cssSelector("#_accountwebsite_id")));
        selectWebsite.selectByVisibleText(website);
        type(firstName, firstNameF);
        type(lastName, lastNameF);
        type(email, emailAddressF);
        Select selectVisible = new Select(driver.findElement(By.cssSelector("#_accountprivacy_allow_hcp_find_me")));
        selectVisible.selectByVisibleText(visible);
        Select selectMembership =  new Select(driver.findElement(By.cssSelector("#_accountmembership_type")));
        selectMembership.selectByVisibleText(membership);
        type(date, dateF);
        Select selectGender = new Select(driver.findElement(By.cssSelector("#_accountgender")));
        selectGender.selectByVisibleText(gender);
        Select selectPregnant = new Select(driver.findElement(By.cssSelector("#_accountpregnant")));
        selectPregnant.selectByVisibleText(pregnant);
        type(height, heightF);
        type(weight, weightF);
        type(password, passwordF);

    }

    public void clickAddresses(){
        clickOn(addresses);
    }

    public void clickDefaultBilling(){
        clickOn(defaultBilling);
    }

    public void fillAddress(String firstname, String lastname, String street, String city, String country, String state, String zipcode, String telephone){
        System.out.println("Filling in address...");
        type(firstname, firstNameFadress);
        type(lastname, lastNameFadress);
        type(street, streetFa);
        type(city, cityF);
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#_item1country_id")));
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.cssSelector("#_item1region_id")));
        selectState.selectByVisibleText(state);
        type(zipcode, zipcodeF);
        type(telephone, telephoneF);
    }

    public BEManageCustomersPageObject saveCustomer (){
        System.out.println("Saving customer ...");
        clickOn(saveCustomer);
        return new BEManageCustomersPageObject(driver);
    }


}
