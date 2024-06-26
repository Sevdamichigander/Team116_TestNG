package tests.day15_crossBrowserTestler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void amazonTest() {

        //driver icin page sayfalarini kullanamayiz. TestBaseCross tan gelen driver i kullanacagiz.

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedicerik = "Nutella";
        WebElement aramaSonucuElementi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualAramaSonucyazisi= aramaSonucuElementi.getText();

        Assert.assertTrue(actualAramaSonucyazisi.contains(expectedicerik));
    }
}
