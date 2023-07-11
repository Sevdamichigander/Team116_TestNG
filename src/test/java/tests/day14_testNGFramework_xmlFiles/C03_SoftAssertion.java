package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_SoftAssertion {
    @Test(groups = "mini regression1")
    public void nutellaTesti(){

        // Butun hatalari ayni anda verir. Boylece hepsini tek seferde duzeltebiliriz.
        //(Biz isteyinceye kadar)Testlerimiz failed olsa bile hatalari not alir ve calismaya devam eder. (JUnit ten farki)
        // Raporla dedigimizde failed olanlari bize soyluyor.


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

        String unexpectedIcerik = "best";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertFalse(actualTitle.contains(unexpectedIcerik));

        //url in "https://www.amazon.com/" oldugunu test edin

        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl);


        //Nutella aratin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edin

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        softAssert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        softAssert.assertAll();

        Driver.closeDriver();


    }
}
