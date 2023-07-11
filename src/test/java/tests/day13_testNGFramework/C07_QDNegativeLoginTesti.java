package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07_QDNegativeLoginTesti {

    //1- https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin
    //3- 3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test(priority = 1)
    public void gecersizPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qdPage.loginButonu.submit();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());

        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void gecersizUsernameTesti() {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qdPage.loginButonu.submit();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());

        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void gecersizUsernameGecersizPasswordTesti() {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qdPage.loginButonu.submit();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());

        Driver.closeDriver();
    }
}
