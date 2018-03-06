package com.opt.pages;

import com.opt.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 1/9/2018.
 */
public class HCPDashboardPageObject extends BasePageObject<HCPDashboardPageObject> {
    private By header = By.cssSelector(".page-title.left>h1");
    private By accreditation = By.cssSelector(".id");
    private By addPatientButton = By.cssSelector(".button.-secondary");
    private By managePatients = By.cssSelector(".button");

    protected HCPDashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(header);
        waitForVisibilityOf(accreditation);
        waitForVisibilityOf(addPatientButton);
        waitForVisibilityOf(managePatients);
    }

    public String getAccreditationID(){
        return getText(accreditation);
    }
}
