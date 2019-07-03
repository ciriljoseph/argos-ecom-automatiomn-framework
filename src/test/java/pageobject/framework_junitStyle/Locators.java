package pageobject.framework_junitStyle;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Locators extends Hooks {

    public void searchAResult(String MySearchExpectedValue) {

        String actualSearchValue = driver.findElement(By.className("search-title__term")).getText();
        assertThat(actualSearchValue, is(Matchers.equalToIgnoringCase(MySearchExpectedValue)));
        System.out.println("My actual " + actualSearchValue + " My expected " + MySearchExpectedValue);
    }


    public void starRating() {
        List<WebElement> custemerRating = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement rating : custemerRating) {
        }
    }

    public void listedPrice(String custmerSellectPrice) {
        List<WebElement> selectedPriceWebElements = driver.findElements(By.cssSelector
                (".ac-facet__filters--default .ac-facet__label--default"));
        for (WebElement sellectedPriceWebelement : selectedPriceWebElements) {
            if (sellectedPriceWebelement.getText().equalsIgnoreCase(custmerSellectPrice)) {
                sellectedPriceWebelement.click();
                break;
            }
        }
    }

    public List<Double> priceAsseration() {
        List<Double> castedPriceList = new ArrayList<>();

        List<WebElement> collectPriceWebelements = driver.findElements(By.className("ac-product-card__prices"));
        for (WebElement collectedPriceElement : collectPriceWebelements) {
            String piceInString = collectedPriceElement.getText().replace("£", " ");
            double priceInDouble = Double.parseDouble(piceInString);
            castedPriceList.add(priceInDouble);
        }
        return castedPriceList;
    }

    List<Double> allPrices = new ArrayList<>();

    public List<Double> priceAllList() {
        List<WebElement> collectedAllElementsPriceLists = driver.findElements(By.className("ac-product-price__amount"));
        for (WebElement collectedAllElementPriceList : collectedAllElementsPriceLists) {
            String priceInString = collectedAllElementPriceList.getText().replace("£", "");
            //casting
            double priceInDouble = Double.parseDouble(priceInString);
            allPrices.add(priceInDouble);
            System.out.println(allPrices);
        }
        return allPrices;
    }

    public void reviewRating(String customerRating) {
        List<WebElement> starRatingWebelements = driver.findElements(By.cssSelector
                (".ac-facet__filters--rating .ac-facet__label"));
        for (WebElement starRatingElement : starRatingWebelements) {
            if (starRatingElement.getText().equalsIgnoreCase(customerRating)) {
                starRatingElement.click();
                break;
            }
        }
    }

    public List<Double> reviewRatingAsseration() {
        List<Double> custemersReview = new ArrayList<>();
        List<WebElement> collectedWebStars = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement collectedstar : collectedWebStars) {
            String reviewInString = collectedstar.getText();
            Double collectedPrice = Double.parseDouble(reviewInString);
            custemersReview.add(collectedPrice);
        }
        return custemersReview;
        // public void randomProduct(){
    }
}