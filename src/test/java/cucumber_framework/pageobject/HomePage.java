package cucumber_framework.pageobject;

import cucumber_framework.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public static String searchitem;

    //creating variable for webelement for page factoty

    @FindBy(id="searchTerm")private WebElement searchBox;
    @FindBy(css="button[type='submit']")private WebElement clickbutton;

    public void doSearch(String item) {
        searchitem = item;
        searchBox.sendKeys(item);
        clickbutton.click();

    }


    /**
     * public void doSearch(String item) {
     * searchitem=item;
     * driver.findElement(By.id("searchTerm")).sendKeys(item + Keys.ENTER);
     * }
     */

    public String getcurrentURL() {
        //  String url = driver.getCurrentUrl();
        //  return url;
        return driver.getCurrentUrl();
    }
}
