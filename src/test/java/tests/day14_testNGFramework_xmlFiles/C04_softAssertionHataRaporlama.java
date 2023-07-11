package tests.day14_testNGFramework_xmlFiles;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_softAssertionHataRaporlama {

    @Test()

    public void nutellaTesti(){

        // Butun hatalari ayni anda verir. Boylece hepsini tek seferde duzeltebiliriz.
        //(Biz isteyinceye kadar)Testlerimiz failed olsa bile hatalari not alir ve calismaya devam eder. (JUnit ten farki)
        // Raporla dedigimizde failed olanlai bize soyluyor.


        //amazona gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
        1- Soft Assert kullanmak icin obje olusturmaliyiz.
        2- Istediginiz tum testleri softAssert objesini kullanarak yapin
        3- Tum tetslerimiz bittiginde
        softAssert objesinin not aldigi hatalari raporlamasini isteyelim
         */

        SoftAssert softAssert = new SoftAssert();


        //title in  best icermedigini test edin

        String unexpectedIcerik = "baton";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertFalse(actualTitle.contains(unexpectedIcerik), "Title istenmeyen icerik barindiriyor");


        //url in "https://www.amazon.com/" oldugunu test edin

        String expectedUrl = "https://www.amazon.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl, "Url beklenenden farkli");

        //Nutella aratin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edin

        String expectedIcerik = "Kutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        softAssert.assertTrue(actualSonucYazisi.contains(expectedIcerik), "Sonuclar Nutella icermiyor");

        softAssert.assertAll(); // Bunu yazmazsak testi yapar ama raporlama yapmadan driver i kapatir.

        //Url beklenenden farkli expected [https://www.amazon.com] but found [https://www.amazon.com/],
        //	Sonuclar Nutella icermiyor expected [true] but found [false]

        /*
        softAssert komutu
        yukarida yapilan tum testleri raporlar
        ve
        failed olan herhangi bir assertion varsa

        java.lang.AssertionError: The following asserts failed:
	expected [https://www.amazon.com] but found [https://www.amazon.com/],
	expected [true] but found [false]

	verip calismayi durdurur.

	Ancak tum hatalari assertAll satirinda verir.
	1 den fazla oldugunda o hatalari ayiklamak mumkun degildir.
	Hatalarin yerini bulmamiz ve duzeltmemiz icin softAssert ile yapilan assertion larda
	mutlaka aciklama yazilmalidir.(Kodun calismasina engel degil, ama kodu anlamayi kolaylastirir)

         */

        Driver.closeDriver();


    }
}


