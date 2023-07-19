package tests.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C01_TestNotation {
    @Test(priority = 34)
    public void ahmet(){
        System.out.println("Ahmet");
    }

    @Test(priority = -10)
    public void sevda(){
        System.out.println("Sevda");
    }

    @Test @Ignore
    public void esat(){
        System.out.println("Esat");
    }

    @Test(priority = -6)
    public void yusuf(){
        System.out.println("Yusuf");
    }
    @Test(dependsOnMethods = "sevda")
    public void yavuz(){
        System.out.println("Yavuz");
    }
    @Test(dependsOnMethods = "yusuf")
    public void murat(){
        System.out.println("Murat");
    }


}
