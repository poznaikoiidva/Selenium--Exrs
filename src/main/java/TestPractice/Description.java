package TestPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Description {
    private WebDriver Driver;
    private int secondsToWait;
    private final String TestPage = "https://practice.automationtesting.in/";
    private final String AcceptChoice = "/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]";
    private final String ShopButton = "/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a";
    private final String Homebutton = "/html/body/div[1]/div[1]/header/div[1]/div/a/img";
    private final String Arrival1 = "//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]";
    //private final List<String> ToBasket = new ArrayList<>();

    private final String ViewBasket = "//*[@id=\"content\"]/div[1]/a";
    private final String Descbutton = "//*[@id=\"product-160\"]/div[3]/ul/li";
    private final String Descbox = "//*[@id=\"tab-description\"]";
    private final String Revibutton = "//*[@id=\"product-160\"]/div[3]/ul/li[2]";
    private final String Reviws = "//*[@id=\"comments\"]";

    public Description(WebDriver Driver, int secondsToWait) {
        this.Driver = Driver;
        this.secondsToWait = secondsToWait;
        //ToBasket.add("//*[@id=\"product-160\"]/div[2]/form/button");
        //ToBasket.add("//*[@id=\"product-163\"]/div[2]/form/button");
        //ToBasket.add("//*[@id=\"product-165\"]/div[2]/form/button");

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

    public int GetArrivals(){
        List<WebElement> arrival = Driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        return arrival.size();
    }

    public boolean ArrivalXPaths(int num) {
        List<WebElement> arrival = Driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        arrival.get(num).click();
        WebElement id = Driver.findElement(By.cssSelector("[id^=product-]"));
        String id_value = id.getAttribute("id");
        String xpath = "//*[@id=\"" + id_value + "\"]/div[2]/form/button";
        WebElement basket = Driver.findElement(By.xpath(xpath));
        if (basket.isDisplayed()) {
            basket.click();
            WebElement Viewbasket = Driver.findElement(By.xpath(ViewBasket));
            if (!Viewbasket.isDisplayed()) {
                return false;
            } else {
                WebElement description = Driver.findElement(By.xpath("//*[@id=\"" + id_value + "\"]/div[3]/ul/li[1]"));
                if (description.isDisplayed()) {
                    description.click();
                    WebElement descriptionbox = Driver.findElement(By.cssSelector("[id=tab-description]"));

                    if (!descriptionbox.isDisplayed()) {
                        return false;
                    } else {
                        System.out.println("Arrival "+ num + " has a description.");
                        WebElement htmlElement = Driver.findElement(By.xpath(Homebutton));
                        htmlElement.click();
                    }
                } else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
}

//*[@id="product-163"]/div[2]/form/button
//*[@id="product-165"]/div[2]/form/button
//descRuby xpath - //*[@id="tab-description"]

//ReviwsRuby xpath - //*[@id="comments"]

