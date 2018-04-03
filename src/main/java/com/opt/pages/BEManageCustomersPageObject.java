package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/10/2017.
 */
public class BEManageCustomersPageObject extends BasePageObject<BEManageCustomersPageObject> {
    private By addCustomer = By.cssSelector("button[title=\"Add New Customer\"]");
    private By header = By.cssSelector(".icon-head.head-customer");
    private By successMsg = By.cssSelector(".success-msg>ul>li>span");

    public void waitForPageToLoad(){
        waitForVisibilityOf(addCustomer);
        waitForVisibilityOf(header);
    }

    public BECustomerInfoPageObject addCustomer() throws IOException {
        System.out.println("Clicking on \"Add New Customer\"");
        clickOn(addCustomer);
        return new BECustomerInfoPageObject(driver);
    }

    protected BEManageCustomersPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public String getSuccessMsg(){
        return getText(successMsg);
    }
}
