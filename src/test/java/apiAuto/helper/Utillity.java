package apiAuto.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.Random;

public class Utillity {
    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/apiAuto/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail(){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" +"_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }
}
