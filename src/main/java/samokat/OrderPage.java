package samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrderPage {
    WebDriver driver;
    String metroElement = ".//div[@class='select-search__select']//*[text()='%s']";
    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By metroField = By.xpath(".//input [@placeholder = '* Станция метро']");
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");
    private final By startDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By periodField = By.xpath(".//div[text() = '* Срок аренды']");
    private final By colorFieldBlack = By.xpath(".//input[@id='black']");
    private final By colorFieldGrey = By.xpath(".//input[@id='grey']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By rentOrderButton = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By yesButton = By.xpath(".//div[2]/button[text() = 'Да']");
    private final By checkOrderStatusButton = By.xpath(".//button[text() = 'Посмотреть статус']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderFieldsForWhom(String firstName, String lastName, String address, String phoneNumber) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void fillOrderFieldMetro(String station) {
        driver.findElement(metroField).click();
        List<WebElement> stationsLists = driver.findElements(By.xpath(String.format(metroElement, station)));
        stationsLists.get(0).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillOrderFieldsAboutRent(String startDate, String comment) {
        driver.findElement(startDateField).sendKeys(startDate);
        driver.findElement(startDateField).sendKeys(Keys.ENTER);
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickPeriodElement(String period) {
        driver.findElement(periodField).click();
        By periodElement = By.xpath(String.format(".//div[text() = '%s']", period));
        driver.findElement(periodElement).click();
    }

    public void colorChoice(String color) {
        if (color == "black") {
            driver.findElement(colorFieldBlack).click();
        } else {
            driver.findElement(colorFieldGrey).click();
        }
    }

    public void clickRentOrderButton() {
        driver.findElement(rentOrderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public boolean checkOrderStatus() {
        return driver.findElement(checkOrderStatusButton).isDisplayed();

    }
}
