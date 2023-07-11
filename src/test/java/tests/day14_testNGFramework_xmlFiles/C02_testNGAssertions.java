package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_testNGAssertions {
    @Test
    public void nutellaTesti(){
        //amazona gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //title in  best icermedigini test edin

        String unexpectedIcerik = "best";
         String actualTitle = Driver.getDriver().getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik), "Title da istenmeyen icerik var.");

        //url in "https://www.amazon.com/" oldugunu test edin

        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Url beklenenden farkli");

        //Nutella aratin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edin

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik), "Arama sonucu Nutella icermiyor.");
        Driver.closeDriver();

    }
}
