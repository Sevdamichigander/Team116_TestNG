package tests.day12_testNG;

import org.testng.annotations.Test;

public class C02_Priority {
    /*
    JUnit te hangi testin once calisacagini ONGOREMEYIZ ve KONTROL EDEMEYIZ.

    TestNG testleri natural order a gore calistirir.

    Eger siralamayi degistirmek isterseniz Test methodlarina priority atayabilirsiniz.
    Priority default olarak 0 degerini alir.
    Ve var olan priority degerlerine gore kucukten buyuge dogru calistirir.

    Eger priority degeri ayni olan methodlar varsa o zaman natural order a bakar.

    @Test(priority = 3) yazarsak 3. test olarak calisir
    ayni sira ise bu sefer alfabetik siraya bakar
    hic siralamazsak default 0 oldugu icin natural order yapar


     */

    @Test(priority = -3)
    public void amazonTest(){
        System.out.println("Amazon");
    }
    @Test(priority = 2)
    public void youtubeTest(){
        System.out.println("Youtube");
    }
    @Test(priority = 1)
    public void wiseTest(){
        System.out.println("Wise");
    }
}
