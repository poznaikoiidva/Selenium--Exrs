package TestPractice;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import java.time.Duration;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;


public class Basket {
    private WebDriver Driver;
    private int secondsToWait;
    private final String TestPage = "https://practice.automationtesting.in/";
    private final String AcceptChoice = "/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]";
    private final String ShopButton = "/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a";
    private final String Homebutton = "/html/body/div[1]/div[1]/header/div[1]/div/a/img";
    private final String Arrival1 = "//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]";
    private final List<String> ToBasket = new ArrayList<>();

    private final String ViewBasket = "//*[@id=\"content\"]/div[1]/a";
    //public String[] arrivalXPaths = {
    //"//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]",
    // "//[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]",
    // "//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]"

    //To Create in future a Array which contains 3 arrivals and the method to call each one check the basket button go back to homepage and continue with the next one.
    //private final String Arrival2 = "//[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]";
    //private final String Arrival3 = "//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]";

    //private final String RubyArrival = "https://practice.automationtesting.in/product/selenium-ruby/"; //link na stranicata s basketa na Ruby
    //private final String ThinkingArrival = "https://practice.automationtesting.in/product/thinking-in-html/"; //link na stranicata s basketa na Thinking
    //private final String MasteringArrival = "https://practice.automationtesting.in/product/mastering-javascript/"; //link na stranicata s basketa na Mastering

    public Basket(WebDriver Driver, int secondsToWait) {
        this.Driver = Driver;
        this.secondsToWait = secondsToWait;
        ToBasket.add("//*[@id=\"product-160\"]/div[2]/form/button");
        ToBasket.add("//*[@id=\"product-163\"]/div[2]/form/button");
        ToBasket.add("//*[@id=\"product-165\"]/div[2]/form/button");
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
        WebElement basket = Driver.findElement(By.xpath(ToBasket.get(num)));
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
}
//*[@id="product-163"]/div[2]/form/button
//*[@id="product-165"]/div[2]/form/button