package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class C02_BagimliTestler {
    /*
    Birbirine bagimli testler olusturalim
    before ve after class ile setup ayarlarini yapalim
    Birbirine bagli testlerle once Wisequarter a gidin
    Wisequarter adresine gidebilirse oradan amazon.com adresine gitsin.
    amazon.com adresine gidebilirse ordan da google.com a gitsin
    driver i kapatsin

     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void wise(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }
    @Test (dependsOnMethods = "wise")
    public void amazon(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @Test (dependsOnMethods = "amazon")
    public void google(){
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }



}
