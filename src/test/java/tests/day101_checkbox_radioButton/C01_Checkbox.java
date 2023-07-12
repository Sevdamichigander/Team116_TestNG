package tests.day101_checkbox_radioButton;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuAppPage;
import utilities.Driver;

public class C01_Checkbox {
    @Test
    public void checkboxTesti(){


         // * Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
         // * a. Verilen web sayfasına gidin.
         // * https://the-internet.herokuapp.com/checkboxes
        Driver.getDriver().get("https://the-internet.herokuapp.com/checkboxes");
         // * b. Checkbox1 ve checkbox2 elementlerini locate edin

        // * c. Checkbox1 seçili değilse onay kutusunu tıklayın

        HerOkuAppPage herOkuApp = new HerOkuAppPage();
        if (!herOkuApp.checkbox1.isSelected()) {
            herOkuApp.checkbox1.click();
        }

         // * d. Checkbox2 seçili değilse onay kutusunu tıklayın

        if (!herOkuApp.checkbox2.isSelected()) {
            herOkuApp.checkbox2.click();
        }

        // * e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

        Assert.assertTrue(herOkuApp.checkbox1.isSelected());
        Assert.assertTrue(herOkuApp.checkbox2.isSelected());


    }
}


