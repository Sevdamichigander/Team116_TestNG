package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Deneme {
    @Test
    public void test01(){
        //1- https://www.qualitydemy.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty(""));

        //2- login linkine basin


        // 3- Kullanici email'i olarak valid email girin
        // 4- Kullanici sifresi olarak valid sifre girin
        // 5- Login butonuna basarak login olun
        // 6- Basarili olarak giris yapilabildigini test edin


        // sayfayi kapatin

        Driver.closeDriver();







    }
}
