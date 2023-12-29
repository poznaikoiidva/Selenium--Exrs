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
    @DisplayName("Expected: The Diamond image is clickable!, Proceeding to add to basket screen. Add to basket button is there!")
    public void basketbutton() {
        Basket homePage = new Basket(Driver, secondsToWait);
        homePage.loadpage();
        homePage.AcceptCookies();
        homePage.ShopButton();
        homePage.HomeButton();
        homePage.GetArrivals();
        homePage.ArrivalXPaths();
        boolean getBakset = homePage.GetToBasketButton();
        Assertions.assertTrue(getBakset, "Basket button is NOT there");
    }

}