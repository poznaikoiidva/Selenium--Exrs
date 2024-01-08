package TestPractice;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class DescTest {
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
    @DisplayName("Expected: All Three arrivals have Description")
    public void description() {
        Description homePage = new Description(Driver, secondsToWait);
        homePage.loadpage();
        homePage.AcceptCookies();
        homePage.ShopButton();
        homePage.HomeButton();
        int num = homePage.GetArrivals();
        for (int i = 0; i < num; i ++) {
            boolean result = homePage.ArrivalXPaths(i);
            Assertions.assertTrue(result, "Arrival " + (i+1)+" Does not have description. ");
        }
    }
}

