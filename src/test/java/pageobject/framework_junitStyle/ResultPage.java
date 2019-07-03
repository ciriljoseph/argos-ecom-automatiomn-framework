package pageobject.framework_junitStyle;

import org.hamcrest.Matchers;
import org.junit.Test;
import pageobject.framework_junitStyle.pageobject_model.HomePage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResultPage extends Hooks {
    private HomePage homePage = new HomePage();
    private Locators locators = new Locators();

    @Test
    public void searchTest() {
        homePage.doSearch("nike");

    }

    @Test
    public void priceTest() {
        homePage.doSearch("nike");
        locators.listedPrice("£5 - £10");
        List<Double> actualPriceList = locators.priceAsseration();
        assertThat(actualPriceList, everyItem(Matchers.greaterThanOrEqualTo(5.00)));
        assertThat(actualPriceList, everyItem(Matchers.lessThanOrEqualTo(10.00)));


    }

    @Test
    public void reviewTest() {
        homePage.doSearch("nike");
        locators.reviewRating("2or more");
        List<Double>actualStarReview =locators.reviewRatingAsseration();
        assertThat(actualStarReview,everyItem(greaterThanOrEqualTo(4.5)));
       assertThat(actualStarReview,everyItem(lessThanOrEqualTo(3.5)));

    }

}
