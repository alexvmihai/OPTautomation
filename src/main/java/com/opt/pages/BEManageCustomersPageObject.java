package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 10/10/2017.
 */
public class BEManageCustomersPageObject extends BasePageObject<BEManageCustomersPageObject> {
    private By addCustomer = By.xpath("html/body/div[1]/div[4]/div/div[2]/table/tbody/tr/td[2]/button");
    private By header = By.xpath("html/body/div[1]/div[4]/div/div[2]/table/tbody/tr/td[1]/h3");

    public void waitForPageToLoad(){
        waitForVisibilityOf(addCustomer);
        waitForVisibilityOf(header);
    }

    public BECustomerInfoPageObject addCustomer(){
        System.out.println("Clicking on \"Add New Customer\"");
        clickOn(addCustomer);
        return new BECustomerInfoPageObject(driver);
    }

    protected BEManageCustomersPageObject(WebDriver driver) {
        super(driver);
    }
}
