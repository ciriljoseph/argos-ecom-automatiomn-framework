package pageobject.framework_junitStyle.pageobject_model;

import org.openqa.selenium.By;
import pageobject.framework_junitStyle.Hooks;

public class HomePage extends Hooks {
    public void doSearch(String searchItem) {

        driver.findElement(By.id("searchTerm")).sendKeys(searchItem);
        driver.findElement(By.className("_2mKaC")).click();

    }
}
