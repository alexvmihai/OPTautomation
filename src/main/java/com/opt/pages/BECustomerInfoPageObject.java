package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by alex.mihai on 10/10/2017.
 */
public class BECustomerInfoPageObject extends BasePageObject<BECustomerInfoPageObject> {
    private By header = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[2]/h3");
    private By continueButton = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[2]/td[2]/span/button");
    private By customerRoleF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[1]/td[2]/select");
    private By websiteF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/select");
    private By firstNameF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[3]/td[2]/input");
    private By lastNameF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[5]/td[2]/input");
    private By emailAddressF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[6]/td[2]/input");
    private By visibleF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[12]/td[2]/select");
    private By membershipF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[15]/td[2]/select");
    private By dateF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[17]/td[2]/input");
    private By genderF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[18]/td[2]/select");
    private By pregnantF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[19]/td[2]/select");
    private By heightF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[20]/td[2]/input");
    private By weightF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[21]/td[2]/input");
    private By passwordF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[4]/div/table/tbody/tr[1]/td[2]/input");
    private By addresses = By.xpath("html/body/div[1]/div[4]/div/div/div[1]/ul/li[4]/a/span");
    //Address fields
    private By defaultBilling = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[1]/ul/li/div/span[1]/label");
    private By firstNameFadress = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/input");
    private By lastNameFadress = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[4]/td[2]/input");
    private By streetFa = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[7]/td[2]/div[1]/input");
    private By cityF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[8]/td[2]/input");
    private By countryF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[9]/td[2]/select");
    private By stateF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[10]/td[2]/select");
    private By zipcodeF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[11]/td[2]/input");
    private By telephoneF = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[12]/td[2]/input");
    private By saveCustomer = By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[2]/p/button[4]"); ///save and continue edit



    protected BECustomerInfoPageObject(WebDriver driver) {
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
        Select selectWebsite = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/select")));
        selectWebsite.selectByVisibleText(website);
        type(firstName, firstNameF);
        type(lastName, lastNameF);
        type(email, emailAddressF);
        Select selectVisible = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[12]/td[2]/select")));
        selectVisible.selectByVisibleText(visible);
        Select selectMembership =  new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[15]/td[2]/select")));
        selectMembership.selectByVisibleText(membership);
        type(date, dateF);
        Select selectGender = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[18]/td[2]/select")));
        selectGender.selectByVisibleText(gender);
        Select selectPregnant = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[4]/div/div[2]/div/table/tbody/tr[19]/td[2]/select")));
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
        Select selectCountry = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[9]/td[2]/select")));
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[5]/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/div/table/tbody/tr[10]/td[2]/select")));
        selectState.selectByVisibleText(state);
        type(zipcode, zipcodeF);
        type(telephone, telephoneF);
    }

    public BECustomerEditPageObject saveCustomer (){
        System.out.println("Saving customer ...");
        clickOn(saveCustomer);
        return new BECustomerEditPageObject(driver);
    }


}
