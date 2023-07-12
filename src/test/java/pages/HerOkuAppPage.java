package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerOkuAppPage {
    public HerOkuAppPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Click Here']")
    public WebElement clickHereButonu;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement checkbox1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkbox2;

    @FindBy(xpath = "//*[text()='Click for JS Alert']")
    public WebElement alert;

    @FindBy(xpath = "//*[@id='result']")
    public WebElement result;





}
