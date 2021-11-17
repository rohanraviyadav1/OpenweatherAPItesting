package baseclass.com;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseclass {

    protected  String baseurl;
    protected  String apiId;
    @BeforeClass
    public void setup(){


        try {

            FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/keyfile.properties");
            Properties prop = new Properties();
            prop.load(fp);
            baseurl=prop.getProperty("testingurl");
            apiId=prop.getProperty("appid");
            //We can set base URI here itself instead of test
            //RestAssured.baseURI = prop.getProperty("testingurl");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
