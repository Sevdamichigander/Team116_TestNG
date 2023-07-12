package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class TestBaseCross {

    protected WebDriver driver;

    @Parameters("browser")

    @BeforeMethod

    public void setUp(@Optional String browser){

        driver= DriverCross.getDriver(browser); // burda driver a atama islemi yaptik. Artik sadece driver yazmak yeterli
    }
    @AfterMethod
    public void tearDown(){
        DriverCross.closeDriver();
    }
}
    /*
    TestBaseCross sınıfından türetilen bir alt classta
    farklı test senaryoları yazmak istediğinizde,
    driver değişkenine alt class ta erişerek onu kullanabilirsiniz.
    Bu şekilde, driver nesnesine erişim sağlayarak alt classlarda ortak bir WebDriver oturumu kullanabilir
     ve tekrar tekrar oluşturmak zorunda kalmazsınız.

    Ancak, access modifier in protected olmasi nedeni ile
    diğer packagelardan veya TestBaseCross classinin dışında bulunan classlardan doğrudan erişim engellenir.
    Bu, driver değişkenini sınıf hiyerarşisinde sınırlı bir erişime sahip olmasını sağlar
    ve tasarımınızı daha modüler hale getirebilir.
    */
