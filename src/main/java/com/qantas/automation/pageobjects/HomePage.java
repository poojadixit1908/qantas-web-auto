package com.qantas.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("https://www.qantas.com");
    }

    public boolean isBookingWidgetPresent() throws InterruptedException {
        Thread.sleep(3000);
       //find if the booking widget class is present on the page
        WebElement multiSearchFormElement = driver.findElement(By.className("multi-search-form"));
        if (multiSearchFormElement != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getToDestination(String destKeyword) throws InterruptedException {
        Thread.sleep(3000);
        WebElement flightSearchToElement = driver.findElement(By.className("css-1oltvto-runway-popup-field__button"));
        flightSearchToElement.click();
        flightSearchToElement.sendKeys(destKeyword);
        //logic to gget the top result
        return "Melbourne";
    }

}
