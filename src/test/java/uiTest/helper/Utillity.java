package uiTest.helper;

import org.apache.commons.lang3.RandomStringUtils;

public class Utillity {

    public static String generateRandomPassword(){
        String password = RandomStringUtils.randomAlphanumeric(10) + "w1@";
        return password;
    }

    public static String generateRandomUsername(){
        String username = RandomStringUtils.randomAlphanumeric(10) + "w1@";
        return username;
    }
}
