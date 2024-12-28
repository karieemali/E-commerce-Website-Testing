package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// read data from (userdata.properties) زي حاله ربط بين ال (testcase & Data)
public class LoadProperties {

    //Load the properties file from the folder
    public static Properties userData;

    static {
        try {
            userData = loadProperties(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\userdata.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties(String path) throws IOException {
        Properties pro = new Properties();
        //Stream from reading file
        FileInputStream stream =new FileInputStream(path);
        pro.load(stream);
        return pro;
    }
}