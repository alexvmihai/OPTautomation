package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by alex.mihai on 10/16/2017.
 */
public class BECustomerEditPageObject extends BasePageObject<BECustomerEditPageObject> {
    private By successMsg = By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/ul/li/ul/li/span");
    private By createOrder = By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/p/button[3]");
    private By deleteCustomer = By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/p/button[4]");
    private By productTags = By.xpath("html/body/div[1]/div[2]/div/div/div[1]/ul/li[18]/a/span");

    protected BECustomerEditPageObject(WebDriver driver) throws IOException {
        super(driver);
    }

    public void waitForPageToLoad (){
        waitForVisibilityOf(createOrder);
        waitForVisibilityOf(deleteCustomer);
        waitForVisibilityOf(productTags);
        System.out.println("Customer Edit Page successfully loaded !");
    }


}
