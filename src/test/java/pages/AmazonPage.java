package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage() {

       PageFactory.initElements(Driver.getDriver(), this);
    }

    /*
            baska package'daki class'larin bu constructor'i kullanabilmeleri icin
        access modifier'ini public yapalim

        bu page class'indan locate kullanacak tum class'lar
        AmazonPage class'indan obje olusturmali==>

        obje olusturmak icin de ==>mutlaka bu Constructor calismali

        ==> o zaman bu class'da WebDriver'imizi tanimlama isini
        bu constructor icinde yapabiliriz

        */

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;


    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-3']")
    public List<WebElement> urunlerListesi;

}
