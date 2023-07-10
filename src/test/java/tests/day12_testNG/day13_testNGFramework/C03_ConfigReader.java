package tests.day12_testNG.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.ConfigReader;

public class C03_ConfigReader {
    @Test
    public void test01(){

        System.out.println(ConfigReader.getProperty("amazonUrl"));

        System.out.println(ConfigReader.getProperty("wiseurl"));// null
        /*
        Key yanlis yaziliesa ConfigReader da ki properties objesi yanlis yazilan key i bulamaz ve null doner.
         */

        System.out.println(ConfigReader.getProperty("kullaniciAdi")); //ahmet




    }
}
