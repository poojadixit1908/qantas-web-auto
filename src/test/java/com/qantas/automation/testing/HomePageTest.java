package com.qantas.automation.testing;

import com.qantas.automation.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class HomePageTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @After
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    @Ignore
    public void testHomePage() {
        homePage.goToHomePage();
    }

    @Test
    @Ignore
    public void testBookingsWidgetIsPresent() throws InterruptedException {
        homePage.goToHomePage();
        boolean isBookingWidgetPresent = homePage.isBookingWidgetPresent();
        Assert.assertTrue("Bookings widget is not present on the home page", isBookingWidgetPresent);
    }

    @Test
    @Ignore
    public void testBookTripFlightsTo() throws InterruptedException {
        String toDestination = homePage.getToDestination("mel");
        Assert.assertEquals("", "Melbourne", toDestination);
    }

    @Test
    @Ignore
    public void testOneWorldLogoText() {
        String logoAlet = homePage.clickOneWorldLogo();
        Assert.assertEquals("", "", logoAlet);

    }

    @Test
    @Ignore
    public void testTopSearchBar() throws InterruptedException {
        homePage.goToHomePage();
        String searchBarResult = homePage.searchTextOnTheTopBar("Australia");
        boolean containsValidResults = searchBarResult.contains("Search for Australia (561 Results)");
        Assert.assertTrue("Result page should contain text: Search for Australia (561 Results)", containsValidResults);


    }

    @Test
    @Ignore
    public void testMyAccount() {
        homePage.goToHomePage();
        homePage.myAccountViaFrequentFlyer("123", "Sharma", "456");
    }

    @Test
    @Ignore
    public void testHelpBar() {
        homePage.goToHomePage();
        //homePage.helpBarOnTop();
    }

    @Test
    public void getScreenShot() throws Exception {
        homePage.goToHomePage();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("/Users/poojasharma/Work/Selenium/screenshots.jpg"));
    }


}
