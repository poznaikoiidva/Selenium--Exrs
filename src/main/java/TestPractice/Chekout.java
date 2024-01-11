package TestPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chekout {
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
    private final String BasketCheck = "//*[@id=\"wpmenucartli\"]";
    private final String ProccedCheckButt = "//*[@id=\"page-34\"]/div/div[1]/div/div/div/a";
    private final String Total = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]";
    private final String TotalCheckout = "//*[@id=\"order_review\"]/table/tfoot/tr[3]";
    public Chekout(WebDriver Driver, int secondsToWait) {
        this.Driver = Driver;
        this.secondsToWait = secondsToWait;
    }


    public void loadpage() {
        Driver.get(TestPage);
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
    }

    public void AcceptCookies() {

        WebElement htmlElement = Driver.findElement(By.xpath(AcceptChoice));
        htmlElement.click();
    }

    public void ShopButton() {
        WebElement htmlElement = Driver.findElement(By.xpath(ShopButton));
        htmlElement.click();
    }

    public void HomeButton() {
        WebElement htmlElement = Driver.findElement(By.xpath(Homebutton));
        htmlElement.click();
    }

    public int GetArrivals() {
        List<WebElement> arrival = Driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        return arrival.size();
    }
    public boolean ArrivalXPaths(int num) {
        List<WebElement> arrival = Driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        arrival.get(num).click();
        WebElement id = Driver.findElement(By.cssSelector("[id^=product-]"));
        String xpath = "//*[@id=\"" + id.getAttribute("id") + "\"]/div[2]/form/button";
        WebElement basket = Driver.findElement(By.xpath(xpath));
        if (basket.isDisplayed()) {
            basket.click();
            WebElement Viewbasket = Driver.findElement(By.xpath(ViewBasket));
            if (!Viewbasket.isDisplayed()) {
                return false;
            } else {
                WebElement htmlElement = Driver.findElement(By.xpath(Homebutton));
                htmlElement.click();
            }
        }
        else {
            return false;
        }
        return true;
    }
    public void Basketcheck(){
        WebElement htmlElement = Driver.findElement(By.xpath(BasketCheck));
        htmlElement.click();
    }
    public int GetBaskets() {
        List<WebElement> basketitem = Driver.findElements(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr"));
        return basketitem.size();
    }
    public boolean BasketItems(int num2){
        List<WebElement> basketitem = Driver.findElements(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr"));
        return basketitem.get(num2).isDisplayed();
    }
    public void Procced(){
        WebElement htmlElement = Driver.findElement(By.xpath(ProccedCheckButt));
        htmlElement.click();
    }
    public void CheckoutTotal() {
        WebElement htmlElement = Driver.findElement(By.xpath(TotalCheckout));
        htmlElement.getText();
        System.out.println("Total price" + TotalCheckout);
    }
}
//*[@id="content"]/div[1]/a
//*[@id="content"]/div[1]/a
//*[@id="content"]/div[1]/a

//*[@id="page-34"]/div/div[1]/div/div/table/tbody/tr[3]

