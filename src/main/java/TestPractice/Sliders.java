package TestPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class Sliders {
    private WebDriver Driver;
    private int secondsToWait;


    public Sliders(WebDriver Driver, int secondsToWait) {
        this.Driver = Driver;
        this.secondsToWait = secondsToWait;

    }


    public void loadpage (String TestPage){
        Driver.get(TestPage);
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondsToWait));
    }
    public void AcceptCookies (String AcceptChoice){

        WebElement htmlElement = Driver.findElement(By.xpath(AcceptChoice));
        htmlElement.click();
    }
    public void ShopButton (String ShopButton){
        WebElement htmlElement = Driver.findElement(By.xpath(ShopButton));
        htmlElement.click();
    }
    public void HomeButton (String Homebutton) {
        WebElement htmlElement = Driver.findElement(By.xpath(Homebutton));
        htmlElement.click();
    }
    public boolean findslider(String Slider) {                   // Funkciq - namerislider narpavihme, TAzi funkciq sledmlako 6te q vikame ot test failut davaiki vseki edin ot 3-te Xpatha po otdelno. Dolniq 39-ti red se opitva da nameri vuprosniq Xpath v stranicata, Ako go ima tova ozna4ava 4e toi su6testvuva i za tova e true i za tova e publick boolian, i taka nie 6te broim elementi.
        try {  //Opitai - Hvani ( nie opitvame da nmerim HTML element s Xpath v Sldier1 i 2 go ima i stava True broikata +1 +1 = 2 , Pri gre6en slider3 Xpath ne su6testvuva i broikata ostava =2 i se hvurlq Exeption, v Catch se pi6e kogato go hvane6 napravi edi kakvo si. v sly4ai dai ne e top !
            WebElement htmlElement = Driver.findElement(By.xpath(Slider));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}