package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.ConfigReader;

public class C03_ConfigReader {

    @Test
    public void test01(){

        System.out.println(ConfigReader.getProperty("amazonUrl"));

        System.out.println(ConfigReader.getProperty("wiseurl"));// null
        /*
        Key yanlis yazilirsa ConfigReader da ki properties objesi yanlis yazilan key i bulamaz
         ve null doner.
         */

        System.out.println(ConfigReader.getProperty("kullaniciAdiAhmet")); //rahmet

    }
}
