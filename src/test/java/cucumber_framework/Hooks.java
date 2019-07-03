package cucumber_framework;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber_framework.driver.DriverFactory;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setup() {
        driverFactory.browserSetUp("Chrome");
        driverFactory.gerUrl("https://www.argos.co.uk/");
        driverFactory.windowMaximice();
        driverFactory.implictWait();
    }

    @After
    public void tearDown() {
        driverFactory.browserQuit();
    }
}

