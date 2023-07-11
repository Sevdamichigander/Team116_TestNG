package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Deneme {
    @Test
    public void test01(){
        // amazona gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //arama kutusuna Nutella yazin

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys("Nutella"  + Keys.ENTER);

        // 12. urunun yazisini gosterin

        String actualUrunIsmi = amazonPage.urunlerListesi.get(11).getText();
        System.out.println(actualUrunIsmi);
        String expectedIcerik = "12x";

        Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
