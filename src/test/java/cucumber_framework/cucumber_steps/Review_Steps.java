package cucumber_framework.cucumber_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_framework.pageobject.HomePage;
import cucumber_framework.pageobject.ResultPage;

public class Review_Steps {
HomePage homePage=new HomePage();
    ResultPage resultPage=new ResultPage();

    @Given("^I am on a Homepage$")
    public void i_am_on_a_Homepage(){
       homePage.doSearch("canon");
    }
    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String myReview){
        resultPage.customerRating();

    }

    @When("^I select price filter$")
    public void i_select_price_filter(){

    }

    @Then("^I should see respective Product of my choice$")
    public void i_should_see_respective_Product_of_my_choice() throws Throwable {

    }

}
