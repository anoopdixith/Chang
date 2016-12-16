package com.kennedy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adixith on 12/15/16.
 */

public class PhoneRegex {

    public static void main(String args[])
    {
        PhoneRegex phoneTest = new PhoneRegex();
        String[] listOfPhoneNumbers = {"123-456-7890", "abc-def-ghij", "1234-56987-7778"};
        for(String phone:listOfPhoneNumbers)
            phoneTest.matchPhoneNumbers(phone);

    }

    private boolean isValid(String input, String pattern) {
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(input);
        return mat.matches();
    }

    protected void matchPhoneNumbers(String input) {
        String pattern = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
        if(isValid(input, pattern)) {
            System.out.println(input);
        }
    }

}
