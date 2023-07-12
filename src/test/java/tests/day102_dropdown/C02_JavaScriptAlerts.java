package tests.day102_dropdown;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.Driver;

public class C02_JavaScriptAlerts {
    @Test
    public void test01(){
       // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
       // - 1.alert’e tiklayin
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();
        herOkuAppPage.alert.click();

        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        String expectedAlertYazisi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        //  -  OK tusuna basip alert'i kapatin
        Driver.getDriver().switchTo().alert().accept();

    }

    @Test
    public void test02(){

        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        //  - 2.alert'e tiklayalim
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage();
        herOkuAppPage.alert.click();

        //  - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        Driver.getDriver().switchTo().alert().dismiss();
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = herOkuAppPage.result.getText();

        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);

    }

}

/*
1. Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 1.alert’e tiklayin
        - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        - OK tusuna basip alert’i kapatin
        2.Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 2.alert’e tiklayalim
        - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        3.Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 3.alert’e tiklayalim
        - Cikan prompt ekranina “Abdullah” yazdiralim
        - OK tusuna basarak alert’i kapatalim
        - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        */

