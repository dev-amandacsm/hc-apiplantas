package hcapiplantas.util;

import java.util.Arrays;
import java.util.Base64;

public class EncondingUtils {

    private EncondingUtils(){

    }

    public static String encode(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String decode(String value){
        return Arrays.toString(Base64.getDecoder().decode(value));
    }


}
