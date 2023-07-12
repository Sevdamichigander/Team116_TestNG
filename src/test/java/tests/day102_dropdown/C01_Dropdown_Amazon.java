package tests.day102_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C01_Dropdown_Amazon {
    @Test
    public void amazonTesti() throws InterruptedException {

        // Amazon anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // arama kutusunun yanindaki dropdown menude 28 secenek oldugunu test edin

        AmazonPage amazonPage = new AmazonPage();

        // dropdown menuyu locate et

        amazonPage.dropdown.click();

        // Select class'indan bir obje olusturalim

        Select select = new Select(amazonPage.dropdown);

        // dropdown menuden Baby kategorisini secin

        select.selectByVisibleText("Baby");


        // Arama kutusuna Nutella yazip aratin

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // bulunan sonuc sayisinin 5'ten az oldugunu test edin

        String sonucYazisi = amazonPage.sonucYaziElementi.getText();
        String sonucYazisiStr = sonucYazisi.substring(0,sonucYazisi.indexOf(" "));
        int sonucYazisiInt = Integer.parseInt(sonucYazisiStr);

        Assert.assertTrue(sonucYazisiInt<5);

        Thread.sleep(5);

        // sectigimiz opsiyonu yazdirin

        System.out.println(select.getFirstSelectedOption().getText());


        // sectigimiz opsiyon'un Baby oldugunu test edin

        String expectedSelectedOption = "Baby";
        String actualSelectedOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);



    }
    @Test
    public void dropdownList(){



        //Tüm dropdown değerleri(value) yazdırın
        // dropdown da ki elementleri bir liste olarak alabiliriz

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.dropdown.click();
        Select select = new Select(amazonPage.dropdown);

        List<WebElement> optionElementleriList = select.getOptions();

        for (WebElement eachElement:optionElementleriList
        ) {
            System.out.println(eachElement.getText());

        }

    }


}
