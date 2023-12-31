package TestPractice;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BasketTest {
    static  WebDriver Driver;
    static int secondsToWait = 12;

    @BeforeAll
    public static void initiate() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        Driver = new ChromeDriver(options);

    }

    @AfterAll
    public static void exit() {
        Driver.close();
        Driver.quit();
    }

    @Test
    @DisplayName("Expected: All Three arrivals can be added to the Basket!")
    public void basketbutton() {
        Basket homePage = new Basket(Driver, secondsToWait);
        homePage.loadpage();
        homePage.AcceptCookies();
        homePage.ShopButton();
        homePage.HomeButton();
        homePage.GetArrivals();
        boolean result = homePage.ArrivalXPaths();
        Assertions.assertTrue(result, "Some of the arrivals are not displayed properly.");
    }

}