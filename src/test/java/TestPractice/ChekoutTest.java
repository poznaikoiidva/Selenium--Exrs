package TestPractice;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class ChekoutTest {
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
    @DisplayName("Expected: Proceed to Check out button is functional!")
    public void Itemmenu() {
        Chekout homePage = new Chekout(Driver, secondsToWait);
        homePage.loadpage();
        homePage.AcceptCookies();
        homePage.ShopButton();
        homePage.HomeButton();
        int num = homePage.GetArrivals();
        for (int i = 0; i < num; i ++) {
            boolean result = homePage.ArrivalXPaths(i);
            Assertions.assertTrue(result, "Arrival " + (i+1)+" Does not have description. ");
        }
        homePage.Basketcheck();
        int num2 = homePage.GetBaskets();
        for (int i = 0; i < num2; i ++) {
            boolean result = homePage.BasketItems(i);
            Assertions.assertTrue(result, "Arrival " + (i + 1) + " Is not listed in to the item menu. ");
        }
        homePage.Procced();
        homePage.CheckoutTotal();{
        }

    }
}
