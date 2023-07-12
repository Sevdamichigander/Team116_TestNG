package tests.day15_TestNGReports_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNutellaTesti extends TestBaseRapor {



    @Test
    public void raporluTest(){

        extentTest = extentReports.createTest("Raporlu Nutella Arama", "Kullanici amazonda Nutella arayabilmeli");

        //amazona gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici anasayfaya gider");

        //Nutella icin arama yapin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Kutella" + Keys.ENTER);
        extentTest.info("Kullanici nutella icin arama yapar");

        //Sonuclarin Nutella icerdigini test edin

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        extentTest.pass("Sonuclarin Nutella icerdigini test eder.");

        //Sayfayi kapatin

        Driver.closeDriver();

    }
}
