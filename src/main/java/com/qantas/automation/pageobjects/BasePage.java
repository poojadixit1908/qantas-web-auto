package com.qantas.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQantasLogo() {
        WebElement logoElement = null;
        logoElement.click();
    }

    public String clickOneWorldLogo() {
        WebElement oneWorldLogo = driver.findElement(By.className("logo-oneworld"));
        oneWorldLogo.click();
        return oneWorldLogo.getText();

    }

    public String searchTextOnTheTopBar(String searchStr) throws InterruptedException {
        Thread.sleep(500);
        WebElement searchBar = driver.findElement(By.className("search-top__button"));
        searchBar.click();
        WebElement searchFormElement = driver.findElement(By.id("search-bar-query-form"));
        WebElement searchSpanElement = searchFormElement.findElement(By.className("search-bar-form__input"));
        WebElement spanSearchInputElement = searchSpanElement.findElement(By.className("search-bar-form__text-input"));
        spanSearchInputElement.sendKeys(searchStr);
        spanSearchInputElement.submit();
        //logic to find the result element
        WebElement searchResultH1Element = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]"));
        return searchResultH1Element.getText();
    }

    public void myAccountViaFrequentFlyer(String membershipNo, String lastName, String pinNo) {
        WebElement frequentFlyer = driver.findElement(By.xpath("//*[@id=\"primary-navigation__frequent-flyer\"]/a"));
        frequentFlyer.click();
        Actions actions = new Actions(driver);
        WebElement myAccountElement = driver.findElement(By.xpath("//*[@id=\"primary-navigation__submenu--frequent-flyer\"]/ul/li[6]/a"));
        actions.moveToElement(myAccountElement);
        myAccountElement.click();
        WebElement membershipNoElement = driver.findElement(By.id("form-member-id-login-menu-frequent-flyer"));
        membershipNoElement.click();
        membershipNoElement.sendKeys(membershipNo);
        WebElement lastNameElement = driver.findElement(By.id("form-member-surname-login-menu-frequent-flyer"));
        lastNameElement.sendKeys("Sharma");
        WebElement memberPin = driver.findElement(By.id("form-member-pin-login-menu-frequent-flyer"));
        memberPin.sendKeys("456");
        WebElement loginButton = driver.findElement(By.className("ql-login-submit-button"));
       // loginButton.submit();
    }
    public void helpBarOnTop() throws InterruptedException {

        WebElement helpElement = driver.findElement(By.xpath("//*[@id=\"primary-navigation__support\"]/a"));
        Thread.sleep(300);
        helpElement.click();




    }
}

