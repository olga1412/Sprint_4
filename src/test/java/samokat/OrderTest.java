package samokat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderTest extends InitTest {

    private final String buttonPosition;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String startDate;
    private final String period;
    private final String color;
    private final String comment;
    private WebDriver driver;

    public OrderTest(String buttonPosition, String firstName, String lastName, String address,
                     String phoneNumber, String station, String startDate, String period, String color, String comment) {

        this.buttonPosition = buttonPosition;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.startDate = startDate;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Below", "Ольга", "Эн", "Москва, Красная площадь, д. 1",
                        "+74991234567", "Театральная", "28.09.2023", "сутки", "black", "Позвонить за час до приезда"},
                {"Top", "Василий", "Егоров", "Москва, Пушкинская площадь, д.3, кв.3",
                        "+79255555555", "Пушкинская", "30.09.2023", "двое суток", "grey", "Нет"},
        };
    }


    @Test
    public void checkOrder() {

        MajorPage objMajorPage = new MajorPage(getDriver());
        objMajorPage.acceptCookie();
        objMajorPage.clickOrderButton(buttonPosition);
        OrderPage objOrderPage = new OrderPage(getDriver());
        objOrderPage.fillOrderFieldsForWhom(firstName, lastName, address, phoneNumber);
        objOrderPage.fillOrderFieldMetro(station);
        objOrderPage.clickNextButton();
        objOrderPage.fillOrderFieldsAboutRent(startDate, comment);
        objOrderPage.clickPeriodElement(period);
        objOrderPage.colorChoice(color);
        objOrderPage.clickRentOrderButton();
        objOrderPage.clickYesButton();
        boolean actual = objOrderPage.checkOrderStatus();

        assertEquals("Заказ не сформирован", true, actual);

    }

}