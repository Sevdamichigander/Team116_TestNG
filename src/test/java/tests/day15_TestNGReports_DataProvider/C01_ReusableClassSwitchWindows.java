package tests.day15_TestNGReports_DataProvider;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ReusableClassSwitchWindows {
    @Test
    public void switchWindowTesti(){

        //https://the-internet.herokuapp.com/windows adresine gidin.

        Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));

        //Click Here butonuna basın.

        HerOkuAppPage herOkuApp = new HerOkuAppPage();
        herOkuApp.clickHereButonu.click();


        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.

        System.out.println(Driver.getDriver().getTitle());//The Internet


        String targetTitle = "New Window";

        ReusableMethods.switchToWindow(targetTitle);
        //ReusableMethods.switchToWindow("New Window");

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        // sayfalari kapatin

        Driver.quitDriver();

    }
}
