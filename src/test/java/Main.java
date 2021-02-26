import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\dell\\Downloads\\chromedriver.exe");

        //Creamos una nueva instancia de Chrome Driver
        WebDriver driver = new ChromeDriver();
        driver.get("http://book.theautomatedtester.co.uk/chapter1");

        driver.manage().window().maximize();
        Thread.sleep(3000);


        waitForAlertBanner(driver);
        assertEquals("Assert that this text is on the page",getAlertBannerText(driver));
        System.out.println("Primera prueba de assert lista");
        submitForm(driver);

    }
    public static void submitForm(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("radiobutton")).click();
        driver.findElement(By.cssSelector("option[value='Selenium RC']")).click();
        driver.findElement(By.name("selected(1234)")).click();
        driver.findElement(By.id("html5div")).sendKeys("\nHola soy ana y esta es una pruebaaaaaaaaaa !!! ");
        driver.findElement(By.id("storeinput")).sendKeys("Hola aquí también ");
        driver.findElement(By.id("secondajaxbutton")).click();
        driver.findElement(By.id("loadajax")).click();
        driver.findElement(By.className("multiplewindow")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.manage().window().maximize();
        Thread.sleep(3000);

        waitForAlertBanner2(driver);
        assertEquals("Text within the pop up window",getAlertBannerText2(driver));
        System.out.println("Segunda prueba de assert lista");

        driver.findElement(By.id("closepopup")).click();


    }
    public static void waitForAlertBanner(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement alert= wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("leftdiv"))));
    }
    public static String getAlertBannerText(WebDriver driver)
    {
        return driver.findElement(By.className("leftdiv")).getText();
    }

    public static void waitForAlertBanner2(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement alert= wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("popuptext"))));
    }
    public static String getAlertBannerText2(WebDriver driver)
    {
        return driver.findElement(By.id("popuptext")).getText();
    }
}