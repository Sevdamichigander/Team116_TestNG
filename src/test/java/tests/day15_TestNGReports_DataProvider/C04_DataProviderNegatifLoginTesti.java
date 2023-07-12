package tests.day15_TestNGReports_DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderNegatifLoginTesti extends TestBaseRapor {

    @DataProvider
    public static Object[][] kullaniciListesi() {

        String[][] kullaniciIsimSifreleri = {{"Sevda","12345"},
                                            {"Murat","45678"},
                                            {"Ahmet","65478"}};

        return kullaniciIsimSifreleri;
    }

    @Test(dataProvider = "kullaniciListesi")

    public void cokluNegatifLoginTesti(String kullaniciAdi, String password){

        extentTest=extentReports.createTest("Data Provider", "Coklu negatif login testi");

        // Qualitydemy anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Kullanici qdemy anasayfaya gider.");


        //Liste olarak verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin.



        //ilk login linkine tiklayin

        QdPage qdpage = new QdPage();
        qdpage.ilkLoginLinki.click();



        //Kullanici adi ve sifresini yazip giris yapmayi deneyin

        qdpage.emailKutusu.sendKeys(kullaniciAdi);
        qdpage.emailKutusu.sendKeys(password);
        qdpage.loginButonu.submit();

        extentTest.info("Verilen " +kullaniciAdi + " ve " +password +" yazip login butonuna basar");

        //giris yapilamadigini test edin

        Assert.assertTrue(qdpage.emailKutusu.isDisplayed());
        extentTest.pass("giris yapilamadigini test eder");

        // Sayfayi kapatin

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");

    }
}
