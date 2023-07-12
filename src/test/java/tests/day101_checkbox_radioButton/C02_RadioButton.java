package tests.day101_checkbox_radioButton;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C02_RadioButton {
    @Test
    public void radioButtonTesti(){

      // a. Verilen web sayfasına gidin.
      //      https://facebook.com
        Driver.getDriver().get("https://facebook.com");

        // b. Cookies’i kabul edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesButton.click();

      // c. Create an account buton’una basin
        facebookPage.creerNouveauCompte.click();

      // d. Radio button elementlerini locate edin ve size uygun olani secin
        facebookPage.buttonFemme.click();

      // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(facebookPage.buttonFemme.isSelected());
        Assert.assertFalse(facebookPage.buttonHomme.isSelected());
        Assert.assertFalse(facebookPage.buttonPersonnalise.isSelected());

    }
}
