package cucumber_framework.pageobject;

import cucumber_framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ResultPage extends DriverFactory {


    public String searchHearder() {
        String headerName = driver.findElement(By.cssSelector("search-title__term")).getText();
        return headerName;
        //return driver.findElement(By.cssSelector("search-title__term")).getText();

    }

    /*-------------------------------------------------------------------------------------------------------------*/
    public void reviewRating(String customerRating) {
      // customerRating=myRevew;

        List<WebElement> starRatingWebelements = driver.findElements(By.cssSelector
                (".ac-facet__filters--rating .ac-facet__lab}el"));
        for (WebElement starRatingElement : starRatingWebelements) {
            if (starRatingElement.getText().equalsIgnoreCase(customerRating)) {
                starRatingElement.click();
                break;
            }
        }
    }

//    List<Double> customerReview = new ArrayList<>();
//
//    public List<Double> customerRating() {
//        List<WebElement> collectedWebelements = driver.findElements(By.cssSelector(".ac-star-rating"));
//        for (WebElement collecetedElement : collectedWebelements) {
//            java.lang.String elementinString = collecetedElement.getText();
//            Double elementInDouble = Double.parseDouble(elementinString);
//            customerReview.add(elementInDouble);
//        }
//        return customerReview;
//    }
    /*----------------------------------------------------------------------------------------------------------------*/



    public List<Double> customerRating() {
        List<Double> customerReview = new ArrayList<>();

        List<WebElement> collectedWebelements = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement collecetedElement : collectedWebelements) {
            String elementinString = collecetedElement.getAttribute("data-star-rating");
            Double elementInDouble = Double.parseDouble(elementinString);
            customerReview.add(elementInDouble);
        }
        return customerReview;

    }
}







