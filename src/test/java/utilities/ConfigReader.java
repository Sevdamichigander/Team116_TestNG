package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;// Properties class indan properties objesi olusturuldu
                                // Boylece configuration.properties ten data cekebiliriz

    static {

        String dosyaYolu= "configuration.properties";

        // throws ile exception yapsaydik her zaman bizden bunu isteyecekti.
        //Onun yerine try catch ile yaptik (tek seferlik)


        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);

        } catch (IOException e) {

            System.out.println("properties dosyasi okunamadi");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);


        /*
        BU methoda biz istedigimiz key i gonderiyoruz
        o da properties objesi kullanarak o key in karsisindaki value yu bize gonderiyor

         */

        /*
        dosyaYolu nu icine koydugumuz static blok en once calisir
         ve istedigimiz on  hazirliklari yapar.
         */
    }
}















