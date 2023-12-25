package TestPractice;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class ArrivalsTest {
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
    @DisplayName("Expected: The Home page must contains only three Arrivals.")
    public void shouldfetchvalue() {
        HomePage homePage = new HomePage(Driver, secondsToWait);
        homePage.loadpage();
        homePage.AcceptCookies();
        homePage.ShopButton();
        homePage.HomeButton();
        int arrivals = homePage.getSliders();
        Assertions.assertEquals(3, arrivals, "Unexpected number of elements in the arrivals");
    }

}