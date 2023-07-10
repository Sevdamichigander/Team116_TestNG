package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;

    // driver i class level da olusturduk.
    // boylece her iki methodda da kullanabiliriz

    public static WebDriver getDriver() {

        /*
        Bundan sonra daha once driver olarak TestBase den alip kullandigimiz WebDriver in yerine
        driver class indan getDriver methodunu kullanacagiz.

        Ancak, mmahserin 4 atlisinda kullandigimiz

                driver= new ChromeDriver();
        problem olusturuyor. Cunku her calistiginda yeniden bir webDriver olusturuyor.

       Bizim istedigimiz sey su :

       Ben testimi calistirmaya basladigimda ilk kez bu methodu kullaninca chromeDriver olustursun
       sonraki kullanimlarda olusturmasin

       bunun icin driver==null kontrol edip ona gore yeni chromeDriver atamasi yapiyoruz

         */

        WebDriverManager.chromedriver().setup();

        if (driver == null) { // Eger driver null ise bunu calistir. Degilse calistirma dedik
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }
        public static void closeDriver() {
            if (driver != null) {
                driver.close();
                driver = null;

            }
        }
    }

