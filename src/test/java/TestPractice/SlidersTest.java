package TestPractice;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SlidersTest {
    static  WebDriver Driver;
    static int secondsToWait = 12;
    private final String TestPage = "https://practice.automationtesting.in/";
    private final String AcceptChoice = "/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]";
    private final String ShopButton = "/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a";
    private final String Homebutton = "/html/body/div[1]/div[1]/header/div[1]/div/a/img";
    private final String Slider1 = "//*[@id=\"n2-ss-6\"]/div[1]";
    private final String Slider2 = " //*[@id=\"n2-ss-6\"]/div[1]/div";
    private final String Slider3 = "//*[@id=\"n2-ss-6\"]/div[1]/div/div";
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
    @DisplayName("Expected: There should be 3 slides.")
    public void shouldfetchvalue() {
        String expectedResult = "3 Sliders";
        Sliders sliders = new Sliders(Driver, secondsToWait);
        sliders.loadpage(TestPage);
        sliders.AcceptCookies(AcceptChoice);
        sliders.ShopButton(ShopButton);
        sliders.HomeButton(Homebutton);
        int broika = 0;
        if (sliders.findslider(Slider1)){
            broika = broika + 1;
        }
        if (sliders.findslider(Slider2)) {
            broika = broika + 1;
        }
        if (sliders.findslider(Slider3)) {
            broika = broika + 1;
        }
        if (broika == 3) {
            System.out.println("Top");
        }
        else {
            System.out.println("Ne e Top");
        }
        //String besicReply = Sliders(WebAdress,elementXpath);
        //System.out.println(besicReply);
        //Assert.assertEquals(sliders.size(), expectedNumberOfSliders, "Number of sliders is not as expected");



        // int expectedNumberOfSliders = 3;
        //            Assert.assertEquals(sliders.size(), expectedNumberOfSliders, "Number of sliders is not as expected");
        //
        //            // If the assertion passes, the following line won't be reached
        //            System.out.println("Test passed! Number of sliders is as expected: " + expectedNumberOfSliders);

    }
}