package tests.day15_TestNGReports_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider_AmazonAramaTesti {


    @DataProvider
    public static Object[][] AranacakUrunListesi() {
        //Dataprovider notation una sahip methodlar
        // ciftkatli array dondurmek zorundadir. Object olmak zorunda degildir.

        String[][] urunList = {{"Nutella"}, {"Cokokrem"}, {"Java"}, {"Selenium"}, {"Apple"}, {"Samsung"}};

        return urunList;
    }

    @Test(dataProvider = "AranacakUrunListesi") // AranacakurunListesine tiklayinca yukarida
                                                // dataprovider notation una sahip bir method olusturur
    public void cokluAramaTesti(String aranacakUrun){

        //amazon anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        //Verilen listedeki herbir urun icin ayri ayri
        //arama yapip, sonuclarin o urunu icerdigini test edin
        //Nutella, Cokokrem, Java, Selenium, Apple, Samsung

        AmazonPage amazonPage = new AmazonPage();

        // Eger ayni test methodunun icinde liste ile yaparsak ilk hata mesajinda test durur. AMA
        // Data Provider bu testi her seferinde yeniden calistiriyo gibi yapar. Disardan bir yerden gelecek/ ANCAK parametre olursa bu bilgi gelebilir.

        amazonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        Assert.assertTrue(amazonPage.sonucYaziElementi.getText().contains(aranacakUrun));

        Driver.closeDriver();

    }
}
