package cucumber_framework.cucumber_steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_framework.driver.DriverFactory;
import cucumber_framework.pageobject.HomePage;
import cucumber_framework.pageobject.ResultPage;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class Search_Steps extends DriverFactory {

    HomePage homePage = new HomePage();
    ResultPage resultPage=new ResultPage();

    @Given("^I am on  Homepage$")
    public void i_am_on_Homepage() {
        String myActual = homePage.getcurrentURL();
        assertThat(myActual, endsWith("co.uk/"));
    }

    @When("^i search of product \"([^\"]*)\"$")
    public void i_search_of_product(String value) {

        homePage.doSearch(value);
    }

    @Then("^Then i should be able to see respective products$")
    public void then_i_should_be_able_to_see_respective_products() {
      String actualSearch =resultPage.searchHearder();
      assertThat(actualSearch,Matchers.is(Matchers.equalToIgnoringCase(homePage.searchitem)));
    }
}
