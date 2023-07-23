package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PageIlkTest {

    @Test
    public void amazonTest(){

        // amazon anasayfaya gidin

        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapin

        /*
        Arama kutusunun locator'ina ihtiyacimiz var.
        locator'larimiz artik pages class'larinda yer aliyor.
        Locator'lar static olmadigi icin obje olusturarak kullanabiliriz.

        Locator icin obje olusturmak lazim
        obje icin de parametresiz bir constructor lazim(page sayfasinda once bu constructor calisir)
        bunun icin de driver ayarlari yapmak lazim
        */


        AmazonPage amazonPage = new AmazonPage();


        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);

        ReusableMethods.bekle(3);


        // sonuclarin Nutella icerdigini test edin

        String expectedIcerik = "Nutella";

        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // Sayfayi kapatin

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
