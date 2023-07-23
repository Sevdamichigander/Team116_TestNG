package tests.day12_testNG;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_TestNG_IlkTest {
    @Test
    public void test01(){

        /*
        Page Object Model(POM) de driver olusturmak ve gerekli ayarlari yapmak icin
         @Testbase kullanmak yerine,
        (utilities in altinda) ayri bir driver class i icerisinde
        bize driver dondurecek bir method olusturulmasi tercih edilmistir.
         */

        Driver.getDriver().get("https://www.amazon.com"); // Driver class inda ki driver i getiriyor.

        ReusableMethods.bekle(5);

        Driver.closeDriver();

        /*
        ===============================================
        Default Suite
        Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
        ===============================================
         */


    }

    @Test
    public void test02(){

        // youtube anasayfaya gidin

        Driver.getDriver().get("https://www.youtube.com");

        //url i yazdirin
        System.out.println(Driver.getDriver().getCurrentUrl());

        //sayfayi kapatin

        Driver.closeDriver();

    }
}
