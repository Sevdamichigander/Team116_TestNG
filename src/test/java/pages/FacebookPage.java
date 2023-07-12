package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailKutuElementi;

    @FindBy(id="pass")
    public WebElement passwordKutuElementi;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[text()='Refuser les cookies optionnels']")
    public WebElement cookiesButton;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement basarisizGirisyaziElementi;

    @FindBy(xpath = "//*[text()='Créer nouveau compte']")
    public WebElement creerNouveauCompte;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement buttonFemme;

    @FindBy(xpath = "//input[@value='2']")
    public WebElement buttonHomme;

    @FindBy(xpath = "//input[@value='-1']")
    public WebElement buttonPersonnalise;




}
