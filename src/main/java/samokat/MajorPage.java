package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MajorPage {
    WebDriver driver;
    private final By orderButtonOnTop = By.className("Button_Button__ra12g");
    private final By orderButtonBelow = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By acceptCookieButton = By.className("App_CookieButton__3cvqF");

    public MajorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebElement element = driver.findElement(acceptCookieButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickOrderButton(String buttonPosition) {
        if (buttonPosition == "Top") {
            WebElement element = driver.findElement(orderButtonOnTop);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(orderButtonOnTop).isEnabled();
            driver.findElement(orderButtonOnTop).click();
        } else if (buttonPosition == "Below") {
            WebElement element = driver.findElement(orderButtonBelow);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(orderButtonBelow).isEnabled();
            driver.findElement(orderButtonBelow).click();
        }
    }

    public void clickQuestionButton(String headingNumber) {
        By questionsButton = By.id(String.format("accordion__heading-%s", headingNumber));
        WebElement element = driver.findElement(questionsButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public boolean checkAnswerText(String panelNumber, String text) {
        By answer = By.id(String.format("accordion__panel-%s", panelNumber));
        WebElement element = driver.findElement(answer);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(element));
        String actual = element.getText();
        return text.equals(actual);

    }
}
