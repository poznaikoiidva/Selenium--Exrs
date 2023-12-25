package TestPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;


public class HomePage {
    private WebDriver Driver;
    private int secondsToWait;
    private final String TestPage = "https://practice.automationtesting.in/";
    private final String AcceptChoice = "/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]";
    private final String ShopButton = "/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a";
    private final String Homebutton = "/html/body/div[1]/div[1]/header/div[1]/div/a/img";

    public HomePage(WebDriver Driver, int secondsToWait) {
        this.Driver = Driver;
        this.secondsToWait = secondsToWait;

    }


    public void loadpage (){
        Driver.get(TestPage);
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
    }
    public void AcceptCookies (){

        WebElement htmlElement = Driver.findElement(By.xpath(AcceptChoice));
        htmlElement.click();
    }
    public void ShopButton (){
        WebElement htmlElement = Driver.findElement(By.xpath(ShopButton));
        htmlElement.click();
    }
    public void HomeButton () {
        WebElement htmlElement = Driver.findElement(By.xpath(Homebutton));
        htmlElement.click();
    }
    public int getSliders(){
        List<WebElement> slider = Driver.findElements(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div"));
        return slider.size();
    }
}