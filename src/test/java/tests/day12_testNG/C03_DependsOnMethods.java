package tests.day12_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DependsOnMethods {
    // amazon anasayfaya gidin

    // 3 farkli test methodu olusturup su testleri yapin

    // 1- url in amazon icerdigini test edin
    //2- Nutella aratip sonucun nutella icerdigini test edin
    //3- ilk urune click yapip acilan sayfadaki urun isminin Nutella icerdigini test edin

    @Test(priority = -5)
    public void urlTest(){

        // 1- url in amazon icerdigini test edin

        Driver.getDriver().get("https://www.amazon.com");

        String expectedUrl = "samazon";

        String actualUrl = Driver.driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test(dependsOnMethods = "urlTest")
    public void nutellaAramaTesti(){
        //2- Nutella aratip sonucun nutella icerdigini test edin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElementi = Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

    @Test(dependsOnMethods = "nutellaAramaTesti")
    public void isimIcerikTest(){
        //3- ilk urune click yapip acilan sayfadaki urun isminin Nutella icerdigini test edin
        Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-base'])[1]")).click();

        WebElement urunIsimElementi = Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik = "Nutella";
        String actualIcerik = urunIsimElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        Driver.closeDriver();

        Driver.closeDriver();

    }
}
