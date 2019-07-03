package com.automation;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Argos_Smoke_TestSuite {

    WebDriver driver;

    @Before
    public void browserSetUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
    }

    public void doASearch(String itemValue) {
        driver.findElement(By.className("_1Rz0y")).sendKeys(itemValue + Keys.ENTER);
    }

    @After
    public void broserQuit() {
        driver.quit();
    }

    @Test
    public void reviewTest() {
        doASearch("nike");
        searchTest("Nike");
        sellectACustermerRating("4or more");
        priceTest("£25 - £50");

    }


    public void searchTest(String expectedValue) {
        String actualValue = driver.findElement(By.className("search-title__term")).getText();

        //CREATING OUR EXPECTED VALUE TO COMPARE WHETHER WE ARE GETTING THE RIGHT VALUE FROM SEARCH BOX
        //String expectedValue = "nike";
        // Removing this variable from inside the method and making this as parameterised

        // junit model asseeration
        //Assert.assertEquals(actualValue, expectedValue);
        //hamcrest model asseration
        assertThat(actualValue, is(Matchers.equalToIgnoringCase(expectedValue)));
    }

    @Test
    public void d()
    {   doASearch("nike");
        sellectACustermerRating("4or more");

        List<Double>actualValue=rtatingAssertation();
        assertThat(actualValue,everyItem(Matchers.greaterThanOrEqualTo(4.0)));
}


    public List<Double> rtatingAssertation() {
        List<Double> filteredRating = new ArrayList<>();

        List<WebElement> starRating = driver.findElements(By.className("ac-star-rating"));
        for (WebElement rating : starRating) {
            String ratingValue = rating.getAttribute("data-star-rating");
            double allRating = Double.parseDouble(ratingValue);

            filteredRating.add(allRating);

        }
            return filteredRating;

    }

@Test
    public void sellectACustermerRating(String sellectedRating) {
        List<WebElement> ratingWebElements = driver.findElements(By.cssSelector
                (".ac-facet__filters--rating .ac-facet__label--rating"));
        for (WebElement custerRating : ratingWebElements) {

            //String sellectedRating = "4or more"; //make parameter

            if (custerRating.getText().equalsIgnoreCase(sellectedRating)) {
                custerRating.click();
                break;
            }
        }
    }

    @Test
    public void addToTrollyTest() {

        doASearch("nike");
        dropeDown("Price: Low - High");


    }

    public void dropeDown(String sortBy) {
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".search__container .ac-product-cta__button--trolley"));
        WebElement dropList = driver.findElement(By.className("sort-select"));
        Select dropDown = new Select(dropList);
        dropDown.selectByVisibleText(sortBy);
    }

    public void addToTrolly() {

        List<WebElement> allProducts = driver.findElements(By.cssSelector(".ac-product-card__cta-row"));
        //allProducts.get(4).click();
        Random random = new Random();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        driver.findElement(By.className("button--full")).click();
        //driver.findElement(By.linkText("Go to Trolley")).sendKeys(Keys.ENTER);
    }

    @Test
    public void runTest() {
        doASearch("nike");
        priceTest("£5 - £10 ");
    }

    public void priceTest(String sellectPrice) {
        List<WebElement> variablePrice = driver.findElements(By.cssSelector
                (".ac-facet__filters--default .ac-facet__label--default"));
        for (WebElement price : variablePrice)
        {
            if (price.getText().equalsIgnoreCase(sellectPrice)) {
                System.out.println(price);
                price.click();

                break;
            }
        }
    }

    @Test
    public void run() {
        doASearch("nike");
        addToBasket();
    }

    public void addToBasket() {

        List<WebElement> productList = driver.findElements(By.cssSelector(".search__container .ac-product-link"));
        Random randomList = new Random();
        int producsInAPage = randomList.nextInt(productList.size());
        productList.get(producsInAPage).click();
        driver.findElement(By.linkText("ADD TO TROLLEY")).click();

    }

}







