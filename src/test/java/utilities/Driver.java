package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver; // driver i class duzeyinde olusturduk.
                                    // Boylece hem getDriver() methodunda
                                    //hem de diger methodlarda rahatlikla kullanabilecegiz.

    private Driver(){

    }

    public static WebDriver getDriver(){

        if(driver == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser){

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge"  :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    /*
    Drive ri kapattiktan sonra onu baslangic noktasina dondurmek icin closeDriver() methodunu yaptik.
     */

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

  /*
            Bundan sonra daha once driver olarak TestBase'den alip kullandigimiz
            WebDriver'in yerine

            Driver class'indan getDriver() methodunu kullanacagiz
            ancak mahserin dort atlisinda kullandigimiz

            driver= new ChromeDriver();

            problem olusturuyor, cunku her calistiginda yeniden bir chromeDriver olusturuyor.

            Bizim istedigimiz sey su :

            ben testimi calistirmaya basladigimda
            ilk kez bu method'u kullaninca ChromeDriver olustursun
            sonraki kullanimlarda olusturmasin

            bunun icin driver == null kontrol edip
            ona gore yeni ChromeDriver atamasi yapiyoruz

         */


        /*
            isyerimizde calisirken
            testlerimizi farkli browser'lar ile calistirmamiz istenebilir.
            Dinamik olarak browser kullanabilmek icin
            configuration.properties dosyamizda browser = istenenBrowser
            seklinde browser'i tanimladik

            Driver class'inda da configuration.properties dosyasindaki
            bilgiyi okuyup, o bilgiye gore istenen browser'i olusturacak
            bir yapi hazirlayalim
         */