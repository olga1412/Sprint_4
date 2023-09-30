package samokat;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constant.URL.URL_SITE;


public abstract class InitTest {
    private WebDriver driver;

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.get(URL_SITE);

    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void leave() {
        driver.quit();
    }

}

